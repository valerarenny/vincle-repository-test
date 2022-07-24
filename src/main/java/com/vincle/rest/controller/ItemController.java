package com.vincle.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vincle.rest.dto.ItemCreateRequestDto;
import com.vincle.rest.dto.ItemDto;
import com.vincle.rest.dto.ItemEditDto;
import com.vincle.rest.handler.ItemHandler;


@RestController
@RequestMapping(
		value = "/v1/item",
		produces = MimeTypeUtils.APPLICATION_JSON_VALUE
)
public class ItemController {
	
	@Autowired
	private ItemHandler handler;
	
	@GetMapping("/")
	public ResponseEntity<List<ItemDto>> getItems(){			
		
		return new ResponseEntity<List<ItemDto>>(handler.getItems(), HttpStatus.OK);
	}
	
	@PostMapping("/")
	public ResponseEntity<String> savePackaging(@RequestBody ItemCreateRequestDto requestCapacity){
		
		handler.saveItem(requestCapacity);
		
		return new ResponseEntity<String>("Succes", HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ItemDto> getItem(@PathVariable Long id){			
		
		return new ResponseEntity<ItemDto>(handler.getItem(id), HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ItemDto> editPackaging(@PathVariable Long id,@RequestBody ItemEditDto requestItem){
		
		return new ResponseEntity<ItemDto>(handler.editItem(id,requestItem), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> editPackaging(@PathVariable Long id){
		
		handler.deleteItem(id);
		
		return new ResponseEntity<String>("Succes", HttpStatus.OK);
	}


}
