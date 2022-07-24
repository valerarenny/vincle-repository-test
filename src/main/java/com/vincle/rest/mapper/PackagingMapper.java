package com.vincle.rest.mapper;

import java.util.ArrayList;
import java.util.List;

import org.mapstruct.Mapper;

import com.vincle.rest.dto.PackagingCreateRequestDto;
import com.vincle.rest.dto.PackagingDto;
import com.vincle.rest.jpa.JPAPackaging;

@Mapper(componentModel = "spring")
public interface PackagingMapper {
	
	default List<PackagingDto> toPackagingsDto (List<JPAPackaging> packaging) {
		List<PackagingDto> pack = new ArrayList<PackagingDto>();
		
		for(JPAPackaging jpaPackaging : packaging) {
			PackagingDto packDto = new PackagingDto();
			packDto.setId(jpaPackaging.getId());			
			packDto.setDescription(jpaPackaging.getDescription());
			packDto.setType(jpaPackaging.getType());
			pack.add(packDto);
		}
		
		return pack;
	}
	
	default PackagingDto toPackagingDto (JPAPackaging optpackaging) {				
		
		PackagingDto packDto = new PackagingDto();
		packDto.setId(optpackaging.getId());			
		packDto.setDescription(optpackaging.getDescription());
		packDto.setType(optpackaging.getType());	
	
		return packDto;
	}
	
	default JPAPackaging toPackagingDtoEdit (JPAPackaging optpackaging, PackagingCreateRequestDto request) {	
		
		optpackaging.setDescription(request.getDescription());
		optpackaging.setType(request.getType());	

		return optpackaging;
	}
}