package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.exception.FlatException;
import com.demo.model.Flat;
import com.demo.service.FlatService;

import jakarta.validation.Valid;

@RestController
public class FlatController {

	@Autowired
	public FlatService flatService;
	
	@PostMapping("/flats")
	public ResponseEntity<Flat> addFlatHandler(@Valid @RequestBody Flat flat)
	{
		return new ResponseEntity<>(flatService.addFlat(flat),HttpStatus.CREATED);
	}
	
	@DeleteMapping("/flats/{flatId}")
	public ResponseEntity<Flat> deleteFlatHandler(@PathVariable Integer flatId) throws FlatException
	{
		return new ResponseEntity<>(flatService.deleteFlat(flatId),HttpStatus.OK);
	}
	
	@PutMapping("/flats")
	public ResponseEntity<Flat> updateFlatHandler(@Valid @RequestBody Flat flat) throws FlatException
	{
			return new ResponseEntity<>(flatService.updateFlat(flat),HttpStatus.OK);
	}
	
	@GetMapping("flats")
	public ResponseEntity<List<Flat>> getAllFlatHandler()
	{
			return new ResponseEntity<List<Flat>>(flatService.findAllFlat(),HttpStatus.OK);
	}
	
	@GetMapping("flats/{flatId}")
	public ResponseEntity<Flat> getFlatByIdHandler(@PathVariable Integer flatId) throws FlatException
	{
			return new ResponseEntity<Flat>(flatService.findFlatById(flatId),HttpStatus.OK);
	}
	
	@GetMapping("/flatsbyprice")
    public Page<Flat> getFlatsByPriceRange(
            @RequestParam Integer minPrice,
            @RequestParam Integer maxPrice,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "ASC") Sort.Direction sortDirection,
            @RequestParam(defaultValue = "price") String sortBy
    ) {
        return flatService.getFlatsByPriceRange(minPrice, maxPrice, page, size, sortDirection, sortBy);
    }
	
	
	
	
}
