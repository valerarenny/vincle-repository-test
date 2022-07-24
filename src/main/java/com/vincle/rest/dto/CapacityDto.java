package com.vincle.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CapacityDto {
	private Long  id;
	private String amount;
	private String units;
	private String description;
}
