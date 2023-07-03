package com.Main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class Controler {
	
@Autowired	
public Service_Customer service_Customer;

@Autowired
public Service_Material service_Material;
	

@GetMapping("/")
public String getdata(Model model) {
	
	model.addAttribute("list", service_Customer.getData());
	
	return "homePage";
	
}

    @GetMapping("/add")
	public String insertdata(Model model) {
		
		model.addAttribute("newData", new Customer());
		
		return "insertCustomer";
	
}
    @PostMapping("/savedata")
    public String SaveData(@ModelAttribute("newData") Customer item) {
    	
    	service_Customer.addData(item);
    	
    	return "redirect:/";
    	
    }
	
    
    
    @GetMapping("/update/{id}")
    public String updateById(@PathVariable(value="id")int id,Model model) {
    	 
    	Customer custo=service_Customer.update(id);
    	model.addAttribute("newUpdate", custo);
    	
    	return "UpdateCustomer";
    }
    

    
    @GetMapping("/delete/{id}")
    public String deleteById(@PathVariable(value = "id")int id) {
    	this.service_Customer .deleteByid(id);
    	
    	return "redirect:/";
    }
 //**************************************************************************************
    
    
    

     @GetMapping("/log")
     public String getdataFunrniture(Model model) {
	
	   model.addAttribute("Furlist", service_Material.getData());
	
	    return "FurniturePage";

     }
     
     

     @GetMapping("/log/addMaterial")
 	public String insertdataFurniture(Model model) {
 		
 		model.addAttribute("newDataFurniture", new Material());
 		
 		return "insertMaterial";
     
     }
     
     @PostMapping("/savedataMaterial")
     public String SaveData(@ModelAttribute("newDataFurniture") Material item) {
     	
     	service_Material.addData(item);
     	
     	return "redirect:/";
     	
     }
     

     @GetMapping("/log/updateMaterial/{id}")
     public String updateByIdMaterial(@PathVariable(value="id")int id,Model model) {
     	 
     	Material material=service_Material.update(id);
     	model.addAttribute("newUpdateMaterial", material);
     	
     	return "UpdateMaterial";
     }
     
     
     @GetMapping("/log/deleteMaterial/{id}")
     public String deleteByIdMaterial(@PathVariable(value = "id")int id) {
     	this.service_Material.deleteByid(id);
     	
     	return "redirect:/";
     }
     

}
