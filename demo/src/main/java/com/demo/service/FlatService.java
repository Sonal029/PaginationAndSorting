package com.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.demo.exception.FlatException;
import com.demo.model.Flat;
import com.demo.repository.FlatRepository;
@Service
public class FlatService {

	@Autowired
	private FlatRepository flatRepo;
		
	public Flat addFlat(Flat flat)
	{
	  return(flatRepo.save(flat));
	}
	
	public Flat deleteFlat(Integer flatId) throws FlatException
	{
		Optional<Flat> optFlat = flatRepo.findById(flatId);
		if(optFlat.isPresent())
		{
			flatRepo.delete(optFlat.get());
			return optFlat.get();
		}
		
		else
		{
			throw new FlatException("invalid Flat Id");
		}
	}
	
	public Flat updateFlat(Flat flat) throws FlatException
	{
		Optional<Flat> optFlat = flatRepo.findById(flat.getFlatId());
		if(optFlat.isPresent())
		{
			Flat updateFlat = (optFlat.get());
			
			updateFlat.setBuildingName(flat.getBuildingName());
			updateFlat.setDate_of_manufacturing(flat.getDate_of_manufacturing());
			updateFlat.setDescription(flat.getDescription());
			updateFlat.setDirection(flat.getDirection());
			updateFlat.setNoOfRooms(flat.getNoOfRooms());
			updateFlat.setPrice(flat.getPrice());
			
			flatRepo.save(updateFlat);
			return updateFlat;
		}
		
		else
		{
			throw new FlatException("invalid Flat Id");
		}
	}

    public Flat findFlatById(Integer flatId) throws FlatException
    {
    	Optional<Flat> optFlat = flatRepo.findById(flatId);
		if(optFlat.isPresent())
		{
			return optFlat.get();
		}
		
		else
		{
			throw new FlatException("Invalid Flat Id");
		}
    }
    
    public List<Flat> findAllFlat()
    {
    	
    	PageRequest p = PageRequest.of(0, 2);
    	Page<Flat> page = flatRepo.findAll(p);
    	List<Flat> flat = page.getContent();
    	
    	
    	return flat;
    }

//    Sorting methods
    
    	public Page<Flat> getFlatsByPriceRange(Integer minPrice, Integer maxPrice, Integer page, Integer size, Sort.Direction sortDirection, String sortBy) {
            PageRequest pageable = PageRequest.of(page, size, Sort.by(sortDirection, sortBy));
            return flatRepo.findByPriceBetween(minPrice, maxPrice, pageable);
        }
}
