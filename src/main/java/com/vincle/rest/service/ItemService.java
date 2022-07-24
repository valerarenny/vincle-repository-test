package com.vincle.rest.service;


import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vincle.rest.dto.ItemCreateRequestDto;
import com.vincle.rest.dto.ItemDto;
import com.vincle.rest.dto.ItemEditCapacityDto;
import com.vincle.rest.dto.ItemEditDto;
import com.vincle.rest.dto.ItemEditPackagingDto;
import com.vincle.rest.jpa.JPACapacity;
import com.vincle.rest.jpa.JPAItem;
import com.vincle.rest.jpa.JPAPackaging;
import com.vincle.rest.mapper.ItemMapper;
import com.vincle.rest.model.ItemStatus;
import com.vincle.rest.repository.CapacityRepository;
import com.vincle.rest.repository.ItemRepository;
import com.vincle.rest.repository.PackagingRepository;

@Service
public class ItemService {
	
	@Autowired
	private ItemRepository itemRepository;
	@Autowired
	private CapacityRepository capacityRepository;
	@Autowired
	private PackagingRepository packagingRepository;
	
	@Autowired
	private ItemMapper mapper;
	
	public void saveItem(ItemCreateRequestDto itemRequest) {
		JPAItem jpaItem = new JPAItem();
		LocalDateTime creation = LocalDateTime.now();		
		
		jpaItem.setClient_id(itemRequest.getClient_id());
		jpaItem.setCooling(itemRequest.getCooling());
		jpaItem.setName(itemRequest.getName());
		jpaItem.setStatus(ItemStatus.CREATED.getDescription());
		jpaItem.setCreated(creation);
		jpaItem.setItemAmount(setCapacity(itemRequest.getCapacity()));
		jpaItem.setItemPresentation(setPackaging(itemRequest.getPackaging()));	
		
		itemRepository.save(jpaItem);
	}
	private Set<JPAPackaging> setPackaging(Set<Long> packaging){
		Iterator<Long> iteratorDto = packaging.iterator();
		Set<JPAPackaging> setpackaging = new HashSet<JPAPackaging>();
		while(iteratorDto.hasNext()) {
			JPAPackaging jpaPackaging = packagingRepository.findById(iteratorDto.next().longValue())
					.orElseThrow(() -> new IllegalStateException("not found packaging "));
			setpackaging.add(jpaPackaging);	
		}
		return setpackaging;
	}
	
	private Set<JPACapacity> setCapacity(Set<Long> capacity){
		Iterator<Long> iteratorDto = capacity.iterator();
		Set<JPACapacity> setCapacity = new HashSet<JPACapacity>();
		while(iteratorDto.hasNext()) {
			JPACapacity jpaCapacity = capacityRepository.findById(iteratorDto.next().longValue())
					.orElseThrow(() -> new IllegalStateException("not found capacity "));
			setCapacity.add(jpaCapacity);	
		}
		return setCapacity;
	}
	
	public List<ItemDto> getItems() {				
		
		List<ItemDto> items = mapper.toItemsDto(itemRepository.findActiveItems());
		
		return items;
	}
	
	public ItemDto getItem(Long id) {				
		
		ItemDto item = mapper.toItemDto(itemRepository.findById(id)
				.orElseThrow(() -> new IllegalStateException("not found item ")));
		
		return item;
	}
	
	public ItemDto editItem(Long id, ItemEditDto request) {
		JPAItem item = mapper.toItemDtoEdit(itemRepository.findById(id)
				.orElseThrow(() -> new IllegalStateException("not found capacity ")), request);
		LocalDateTime edition = LocalDateTime.now();		
		item.setUpdated(edition);
		setNewItemCapacity(item,request);
		itemRepository.save(item);
		return mapper.toItemDto(item);
	}
	
	public void setNewItemCapacity(JPAItem item , ItemEditDto request) {
		Set<JPACapacity> capacitySet = item.getItemAmount();
		for(JPACapacity jpaCapacity : capacitySet) {
			for(ItemEditCapacityDto capacityDto : request.getCapacitys()) {
				if(jpaCapacity.getId() == capacityDto.getOldId() ) {
					item.removeCapacity(jpaCapacity);
					JPACapacity newCapacity = capacityRepository.findById(capacityDto.getNewId()).orElseThrow(() -> new IllegalStateException("not found capacity "));
					item.addCapacity(newCapacity);
				}				
			}
		}
	}
	
	public void setNewItemPackaging(JPAItem item , ItemEditDto request) {
		Set<JPAPackaging> packagingSet = item.getItemPresentation();
		for(JPAPackaging jpaPackaging : packagingSet) {
			for(ItemEditPackagingDto packagingDto : request.getPackagings()) {
				if(jpaPackaging.getId() == packagingDto.getOldId() ) {
					item.removeCapacity(jpaPackaging);
					JPAPackaging newPackaging = packagingRepository.findById(packagingDto.getNewId()).orElseThrow(() -> new IllegalStateException("not found packaging "));
					item.addPacking(newPackaging);
				}				
			}
		}
	}
	
	public void deleteItem(Long id) {			
		JPAItem item = itemRepository.findById(id)
				.orElseThrow(() -> new IllegalStateException("not found capacity "));
		LocalDateTime deletion = LocalDateTime.now();
		item.setDeleted(deletion);
		item.setStatus(ItemStatus.DELETED.getDescription());
		itemRepository.save(item);
	}

}
