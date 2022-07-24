package com.vincle.rest.repository;

import com.vincle.rest.jpa.JPAPackaging;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;


@Repository
public interface PackagingRepository extends JpaRepository<JPAPackaging, Long>, JpaSpecificationExecutor<JPAPackaging> {

}
