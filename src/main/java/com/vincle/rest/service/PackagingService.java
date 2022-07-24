package com.vincle.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vincle.rest.dto.PackagingCreateRequestDto;
import com.vincle.rest.dto.PackagingDto;
import com.vincle.rest.jpa.JPAPackaging;
import com.vincle.rest.mapper.PackagingMapper;
import com.vincle.rest.repository.PackagingRepository;

@Service
public class PackagingService {
	@Autowired
	private PackagingRepository packagingRepository;
	
	@Autowired
	private PackagingMapper mapper;
	
	public void saveCapacity(PackagingCreateRequestDto packagingRequest) {
		JPAPackaging jpaPackaging = new JPAPackaging();
		jpaPackaging.setType(packagingRequest.getType());
		jpaPackaging.setDescription(packagingRequest.getDescription());				
		
		packagingRepository.save(jpaPackaging); 
	}
	
	public List<PackagingDto> getPackagings() {				
		
		List<PackagingDto> capacitys = mapper.toPackagingsDto(packagingRepository.findAll());
		
		return capacitys;
	}
	
	public PackagingDto getPackaging(Long id) {				
		
		PackagingDto packaging = mapper.toPackagingDto(packagingRepository.findById(id)
				.orElseThrow(() -> new IllegalStateException("not found capacity ")));
		
		return packaging;
	}
	
	public PackagingDto editPackaging(Long id, PackagingCreateRequestDto request) {	
		
		JPAPackaging packaging = mapper.toPackagingDtoEdit(packagingRepository.findById(id)
				.orElseThrow(() -> new IllegalStateException("not found packaging ")), request);		
		packagingRepository.save(packaging);
		
		return mapper.toPackagingDto(packaging);
	}
}
