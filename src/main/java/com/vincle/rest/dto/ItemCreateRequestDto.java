package com.vincle.rest.dto;

import java.time.LocalDateTime;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemCreateRequestDto {	
	private Boolean cooling;
	private String name;	
	private LocalDateTime created;	
	private String client_id;
	private Set<Long> packaging;
	private Set<Long> capacity;
}

