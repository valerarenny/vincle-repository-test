package com.vincle.rest.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vincle.rest.dto.CapacityCreateRequestDto;
import com.vincle.rest.dto.CapacityDto;
import com.vincle.rest.jpa.JPACapacity;
import com.vincle.rest.mapper.CapacityMapper;
import com.vincle.rest.repository.CapacityRepository;

@Service
public class CapacityService {
	
	@Autowired
	private CapacityRepository capacityRepository;
	
	@Autowired
	private CapacityMapper mapper;
	
	public void saveCapacity(CapacityCreateRequestDto capacityRequest) {
		JPACapacity jpaCapacity = new JPACapacity();
		jpaCapacity.setAmount(new BigDecimal(capacityRequest.getAmount()));
		jpaCapacity.setDescription(capacityRequest.getDescription());
		jpaCapacity.setUnits(capacityRequest.getUnits());		
		
		capacityRepository.save(jpaCapacity);
	}
	
	public List<CapacityDto> getCapacitys() {				
		
		List<CapacityDto> capacitys = mapper.toCapacitysDto(capacityRepository.findAll());
		
		return capacitys;
	}
	
	public CapacityDto getCapacity(Long id) {				
		
		CapacityDto capacity = mapper.toCapacityDto(capacityRepository.findById(id)
				.orElseThrow(() -> new IllegalStateException("not found capacity ")));
		
		return capacity;
	}
	
	public CapacityDto editCapacity(Long id, CapacityCreateRequestDto request) {	
		
		JPACapacity capacity = mapper.toCapacityDtoEdit(capacityRepository.findById(id)
				.orElseThrow(() -> new IllegalStateException("not found capacity ")), request);		
		capacityRepository.save(capacity);
		
		return mapper.toCapacityDto(capacity);
	}
}
