package com.vincle.rest.dto;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemEditDto {	
	private Boolean cooling;
	private String name;	
	private Set<ItemEditPackagingDto> packagings;
	private Set<ItemEditCapacityDto> capacitys;
	private String client_id;
}
