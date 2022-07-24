package com.vincle.rest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.vincle.rest.jpa.JPAItem;
import com.vincle.rest.jpa.JPAPackaging;

@Repository
public interface ItemRepository extends JpaRepository<JPAItem, Long>, JpaSpecificationExecutor<JPAPackaging>  {
	
	@Query(value = "SELECT * FROM items.item WHERE item.status = 'Creado' " , nativeQuery = true)
	public List<JPAItem> findActiveItems();
}
