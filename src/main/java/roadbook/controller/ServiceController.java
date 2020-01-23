package roadbook.controller;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import roadbook.model.Service;
import roadbook.repository.ServiceRepository;

@RestController
public class ServiceController {
	@Autowired
	private ServiceRepository serviceRepository;
	
	@RequestMapping("/services")
	public Collection<Service> findAll(){

		return serviceRepository.findAll();
	}
	@GetMapping("/serviceById/{id}")
	public Optional<Service> findById(@PathVariable Integer id) {
		return serviceRepository.findById(id);
	}
	
	
	@GetMapping("/servicesByCategorie/{categorie}")
	public Optional<Service> findByCategorie(@PathVariable String categorie) {
		return serviceRepository.findByCategorie(categorie);
	}
	
	 
	    @PostMapping("/addService")
	    public Service ajoutService(@RequestBody Service service){
	        return serviceRepository.saveAndFlush(service);
	    }
	    
	    @RequestMapping("/delService/{id}")
	    public void delOne(@PathVariable int id) {
	        Optional<Service> optEvent = serviceRepository.findById(id);
	        if (optEvent.isPresent()) {
	        	serviceRepository.deleteById(id);
	            System.out.println("Action supprimée");
	        } else {
	            System.out.println("Pas d'action à supprimer");
	        }
	    }
}
