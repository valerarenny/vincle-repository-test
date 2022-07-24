package com.vincle.rest.handler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vincle.rest.dto.CapacityCreateRequestDto;
import com.vincle.rest.dto.CapacityDto;
import com.vincle.rest.service.CapacityService;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CapacityHandler {
	
	@Autowired
	private CapacityService capacityService;
	 
	public void saveCapacity (CapacityCreateRequestDto request) {
		
		capacityService.saveCapacity(request);
		
	}
	
	public List<CapacityDto> getCapacitys() {
		
		return capacityService.getCapacitys();
	}
	
	public CapacityDto getCapacity(Long id) {
		
		return capacityService.getCapacity(id);
	}
	
	public CapacityDto editCapacity(Long id, CapacityCreateRequestDto request) {
		
		return capacityService.editCapacity(id, request);
	}

}
