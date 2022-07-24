package com.vincle.rest.jpa;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="item",schema="items")
public class JPAItem {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	@Column(name = "id")
	private Long id;
	private Boolean cooling;
	private String name;
	private String status;
	private LocalDateTime created;
	private LocalDateTime updated;
	private LocalDateTime deleted;
	private String client_id;
	
	@ManyToMany
	@JoinTable(schema = "items", name="item_packaging",
			joinColumns = {
	                @JoinColumn(name = "item_id"),},
	            inverseJoinColumns = {
	                @JoinColumn(name = "packaging_id")})
	private Set<JPAPackaging> itemPresentation = new HashSet<>(); 
	
	@ManyToMany
	@JoinTable(schema = "items", name="item_capacity",
			joinColumns = {@JoinColumn(name = "item_id")},
	        inverseJoinColumns = {@JoinColumn(name = "capacity_id")}
	            )
	private Set<JPACapacity> itemAmount = new HashSet<>(); 
	
	public void addCapacity(JPACapacity capacity) {
        this.itemAmount.add(capacity);
        capacity.getProducts().add(this);
    }
	 
    public void removeCapacity(JPACapacity capacity) {
    	this.itemAmount.remove(capacity);
    	capacity.getProducts().remove(this);
    }
    
    public void addPacking(JPAPackaging packaging) {
        this.itemPresentation.add(packaging);
        packaging.getProducts().add(this);
    }
	 
    public void removeCapacity(JPAPackaging packaging) {
    	this.itemPresentation.remove(packaging);
    	packaging.getProducts().remove(this);
    }
}
