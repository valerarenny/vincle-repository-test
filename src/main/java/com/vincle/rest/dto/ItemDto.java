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
public class ItemDto {
	private Long id;
	private Boolean cooling;
	private String name;
	private String status;
	private Set<PackagingDto> packagings;
	private Set<CapacityDto> capacitys;
	private LocalDateTime created;
	private LocalDateTime updated;
	private LocalDateTime deleted;
	private String client_id;
}
