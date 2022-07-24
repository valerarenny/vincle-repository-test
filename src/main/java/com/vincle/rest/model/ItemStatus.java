package com.vincle.rest.model;

import java.util.Optional;
import java.util.stream.Stream;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ItemStatus {
	 	CREATED(1, "Creado"),
	    WAITING(2, "Procesando"),
	    DELETED(3, "Eliminado");

	    final Integer code;
	    final String description;

	    public static Optional<ItemStatus> fromCode(Integer code) {
	        return Stream.of(ItemStatus.values()).filter(eventType -> eventType.getCode().equals(code)).findFirst();
	    }
}
