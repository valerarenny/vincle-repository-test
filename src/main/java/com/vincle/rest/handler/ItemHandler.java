package com.vincle.rest.handler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vincle.rest.dto.ItemCreateRequestDto;
import com.vincle.rest.dto.ItemDto;
import com.vincle.rest.dto.ItemEditDto;
import com.vincle.rest.service.ItemService;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ItemHandler {
	
	@Autowired
	private ItemService itemService;
	 
	public void saveItem (ItemCreateRequestDto request) {
		
		itemService.saveItem(request);		
	}
	
	public List<ItemDto> getItems() {
		
		return itemService.getItems();
	}
	
	public ItemDto getItem(Long id) {
		
		return itemService.getItem(id);
	}
	
	public ItemDto editItem(Long id, ItemEditDto request) {
		
		return itemService.editItem(id, request);
	}
	
	public void deleteItem(Long id) {
		
		itemService.deleteItem(id);
	}
}
