package com.demo.repository;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.demo.model.Flat;

@Repository
public interface FlatRepository extends JpaRepository<Flat, Integer> , PagingAndSortingRepository<Flat, Integer>{
	
	
//    Page<Flat> findByPriceBetween(double minPrice, double maxPrice, Pageable pageable);

	Page<Flat> findByPriceBetween(double minPrice, double maxPrice, PageRequest pageable);

}
