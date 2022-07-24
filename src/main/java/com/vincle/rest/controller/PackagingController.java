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

import com.vincle.rest.dto.PackagingCreateRequestDto;
import com.vincle.rest.dto.PackagingDto;
import com.vincle.rest.handler.PackagingHandler;

@RestController
@RequestMapping(
		value = "/v1/packaging",
		produces = MimeTypeUtils.APPLICATION_JSON_VALUE
)
public class PackagingController {
	
	@Autowired
	private PackagingHandler handler;
	
	@GetMapping("/")
	public ResponseEntity<List<PackagingDto>> getPackagings(){			
		
		return new ResponseEntity<List<PackagingDto>>(handler.getPackagings(), HttpStatus.OK);
	}
	
	@PostMapping("/")
	public ResponseEntity<String> savePackaging(@RequestBody PackagingCreateRequestDto requestCapacity){
		
		handler.savePackaging(requestCapacity);
		
		return new ResponseEntity<String>("Succes", HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<PackagingDto> getPackaging(@PathVariable Long id){			
		
		return new ResponseEntity<PackagingDto>(handler.getPackaging(id), HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<PackagingDto> editPackaging(@PathVariable Long id,@RequestBody PackagingCreateRequestDto requestCapacity){
		
		handler.editPackaging(id,requestCapacity);
		
		return new ResponseEntity<PackagingDto>(handler.editPackaging(id,requestCapacity), HttpStatus.OK);
	}

}
