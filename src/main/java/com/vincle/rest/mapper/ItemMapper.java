package com.vincle.rest.mapper;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.mapstruct.Mapper;

import com.vincle.rest.dto.CapacityDto;
import com.vincle.rest.dto.ItemDto;
import com.vincle.rest.dto.ItemEditDto;
import com.vincle.rest.dto.PackagingDto;
import com.vincle.rest.jpa.JPACapacity;
import com.vincle.rest.jpa.JPAItem;
import com.vincle.rest.jpa.JPAPackaging;

@Mapper(componentModel = "spring")
public interface ItemMapper {
	default List<ItemDto> toItemsDto (List<JPAItem> items) {
		List<ItemDto> pack = new ArrayList<ItemDto>();
		
		for(JPAItem jpaItem : items) {
			ItemDto itemDto = new ItemDto();
			itemDto.setId(jpaItem.getId());
			itemDto.setCooling(jpaItem.getCooling());
			itemDto.setName(jpaItem.getName());
			itemDto.setClient_id(jpaItem.getClient_id());
			itemDto.setCreated(jpaItem.getCreated());
			itemDto.setStatus(jpaItem.getStatus());
			itemDto.setDeleted(null);
			itemDto.setUpdated(null);
			
			itemDto.setCapacitys(toCapacityDto(jpaItem.getItemAmount()));
			itemDto.setPackagings(toPackagingDto(jpaItem.getItemPresentation()));		

			pack.add(itemDto);
		}
		
		return pack;
	}
	
	default ItemDto toItemDto (JPAItem optItem) {				
		
		ItemDto itemDto = new ItemDto();
		itemDto.setId(optItem.getId());
		itemDto.setClient_id(optItem.getClient_id());
		itemDto.setCreated(optItem.getCreated());
		itemDto.setUpdated(optItem.getUpdated());
		itemDto.setPackagings(toPackagingDto(optItem.getItemPresentation()));
		itemDto.setCapacitys(toCapacityDto(optItem.getItemAmount()));
		itemDto.setCooling(optItem.getCooling());
		itemDto.setStatus(optItem.getStatus());
		itemDto.setName(optItem.getName());
	
		return itemDto;
	}
	
	default Set<PackagingDto> toPackagingDto (Set<JPAPackaging> optPackaging) {				
		Set<PackagingDto> pack = new HashSet<PackagingDto>();
		for(JPAPackaging jpaPackaging : optPackaging) {
			PackagingDto packagingDto = new PackagingDto();
			packagingDto.setId(jpaPackaging.getId());
			packagingDto.setDescription(jpaPackaging.getDescription());
			packagingDto.setType(jpaPackaging.getType());		
			
			pack.add(packagingDto);
		}
	
		return pack;
	}
	
	default Set<CapacityDto> toCapacityDto (Set<JPACapacity> optCapacity) {				
		Set<CapacityDto> cap = new HashSet<CapacityDto>();
		for(JPACapacity jpaCapacity : optCapacity) {
			CapacityDto capacityDto = new CapacityDto();
			capacityDto.setId(jpaCapacity.getId());
			capacityDto.setDescription(jpaCapacity.getDescription());
			capacityDto.setAmount(jpaCapacity.getAmount().toString());
			capacityDto.setUnits(jpaCapacity.getUnits());			
			
			cap.add(capacityDto);
		}
	
		return cap;
	}
	
	default JPAItem toItemDtoEdit (JPAItem optItem, ItemEditDto request) {
		
		optItem.setClient_id(request.getClient_id());
		optItem.setCooling(request.getCooling());
		optItem.setName(request.getName());
		
		return optItem;
	}
}
