package com.vincle.rest.handler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vincle.rest.dto.PackagingCreateRequestDto;
import com.vincle.rest.dto.PackagingDto;
import com.vincle.rest.service.PackagingService;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class PackagingHandler {
	@Autowired
	private PackagingService packagingService;
	 
	public void savePackaging (PackagingCreateRequestDto request) {
		
		packagingService.saveCapacity(request);		
	}
	
	public List<PackagingDto> getPackagings() {
		
		return packagingService.getPackagings();
	}
	
	public PackagingDto getPackaging(Long id) {
		
		return packagingService.getPackaging(id);
	}
	
	public PackagingDto editPackaging(Long id, PackagingCreateRequestDto request) {
		
		return packagingService.editPackaging(id, request);
	}
}
