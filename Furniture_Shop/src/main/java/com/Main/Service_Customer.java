package com.Main;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Service_Customer {
	
	
	@Autowired
	public CustomerRepository repository;
	
	
	
	public List getData() {
		List<Customer> list=new ArrayList<Customer>();
		
		repository.findAll().forEach(list::add);
		
		return list;
	}
	
	

	
	public void addData(Customer item) {
		repository.save(item);
	}
	
	
	
	
	public Customer update(int id) {
		
		Optional<Customer> optional=repository.findById(id);
		Customer custo=null;
		
		if(optional.isPresent()) {
			
			custo=optional.get();
		}
		else {
			throw new RuntimeException("Employee not found ::"+id);
		}
		
		return custo;
	}
	

	public void deleteByid(int id) {
		repository.deleteById(id);
	
}

}
