package com.vincle.rest.dto;

import java.time.LocalDateTime;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemDto {
	
	@JsonProperty("id")
	private Long id;
	
	@JsonProperty("cooling")
	private Boolean cooling;
	
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("status")
	private String status;
	
	@JsonProperty("packagings")
	private Set<PackagingDto> packagings;
	
	@JsonProperty("capacitys")
	private Set<CapacityDto> capacitys;
	
	@JsonProperty("created")
	private String created;
	
	@JsonProperty("updated")
	private String updated;
	
	@JsonProperty("deleted")
	private String deleted;
	
	@JsonProperty("client_id")
	private String client_id;
}
