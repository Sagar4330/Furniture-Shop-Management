package com.Main;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Service_Material {
	
	@Autowired
	public MaterialRepository repository;

	public List<Material> getData() {
		
		List<Material> Furnlist=new ArrayList<Material>();
		
		repository.findAll().forEach(Furnlist::add);
		
		return Furnlist;
	}
	

	public void addData(Material item) {
		repository.save(item);
	}
	
	
       public Material update(int id) {
		
		Optional<Material> optional=repository.findById(id);
		Material material=null;
		
		if(optional.isPresent()) {
			
			material=optional.get();
		}
		else {
			throw new RuntimeException("Employee not found ::"+id);
		}
		
		return material;
	}
       
       public void deleteByid(int id) {
   		repository.deleteById(id);
   	
   }
	

}
