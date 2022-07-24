package com.vincle.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.vincle.rest.jpa.JPACapacity;

@Repository
public interface CapacityRepository extends JpaRepository<JPACapacity, Long>, JpaSpecificationExecutor<JPACapacity>{
	
}
 