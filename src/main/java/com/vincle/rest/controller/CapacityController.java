package com.vincle.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vincle.rest.dto.CapacityCreateRequestDto;
import com.vincle.rest.dto.CapacityDto;
import com.vincle.rest.handler.CapacityHandler;

@RestController
@RequestMapping(
		value = "/v1/capacity",
		produces = MimeTypeUtils.APPLICATION_JSON_VALUE
)
public class CapacityController {
	
	@Autowired
	private CapacityHandler handler;
	
	@GetMapping("/")
	public ResponseEntity<List<CapacityDto>> getCapacitys(){			
		
		return new ResponseEntity<List<CapacityDto>>(handler.getCapacitys(), HttpStatus.OK);
	}
	
	@PostMapping("/")
	public ResponseEntity<String> saveCapacity(@RequestBody CapacityCreateRequestDto requestCapacity){
		
		handler.saveCapacity(requestCapacity);
		
		return new ResponseEntity<String>("Succes", HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CapacityDto> getCapacity(@PathVariable Long id){			
		
		return new ResponseEntity<CapacityDto>(handler.getCapacity(id), HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<CapacityDto> editCapacity(@PathVariable Long id,@RequestBody CapacityCreateRequestDto requestCapacity){
		
		handler.editCapacity(id,requestCapacity);
		
		return new ResponseEntity<CapacityDto>(handler.editCapacity(id,requestCapacity), HttpStatus.OK);
	}
}
