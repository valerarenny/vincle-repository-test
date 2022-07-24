package com.vincle.rest.mapper;

import java.util.List;
import java.math.BigDecimal;
import java.util.ArrayList;

import org.mapstruct.Mapper;

import com.vincle.rest.dto.CapacityCreateRequestDto;
import com.vincle.rest.dto.CapacityDto;
import com.vincle.rest.jpa.JPACapacity;



@Mapper(componentModel = "spring")
public interface CapacityMapper {
	
	default List<CapacityDto> toCapacitysDto (List<JPACapacity> capacity) {
		List<CapacityDto> cap = new ArrayList<CapacityDto>();
		
		for(JPACapacity jpaCapacity : capacity) {
			CapacityDto capDto = new CapacityDto();
			capDto.setId(jpaCapacity.getId());
			capDto.setAmount(jpaCapacity.getAmount().toString());
			capDto.setDescription(jpaCapacity.getDescription());
			capDto.setUnits(jpaCapacity.getUnits());
			cap.add(capDto);
		}
		
		return cap;
	}
	
	default CapacityDto toCapacityDto (JPACapacity optcapacity) {				
		
			CapacityDto capDto = new CapacityDto();
			capDto.setId(optcapacity.getId());
			capDto.setAmount(optcapacity.getAmount().toString());
			capDto.setDescription(optcapacity.getDescription());
			capDto.setUnits(optcapacity.getUnits());			
		
	
		return capDto;
	}
	
	default JPACapacity toCapacityDtoEdit (JPACapacity optcapacity, CapacityCreateRequestDto request) {		
		
		optcapacity.setAmount(new BigDecimal(request.getAmount()));
		optcapacity.setDescription(request.getDescription());
		optcapacity.setUnits(request.getUnits());	

	return optcapacity;
}
}
