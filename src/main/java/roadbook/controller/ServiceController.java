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

import roadbook.model.Evenement;
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
	public Collection<Service> findByCategorie(@PathVariable String categorie) {
		return serviceRepository.findAllByCategorie(categorie);
	}
	
	 
	    @PostMapping("/addService")
	    public Service ajoutService(@RequestBody Service service){
	        return serviceRepository.saveAndFlush(service);
	    }
	    
	    @RequestMapping("/delService/{id}")
	    public void delOne(@PathVariable int id) {
	        Optional<Service> optService = serviceRepository.findById(id);
	        if (optService.isPresent()) {
	        	serviceRepository.deleteById(id);
	            System.out.println("Action supprimée");
	        } else {
	            System.out.println("Pas d'action à supprimer");
	        }
	    }
		@PostMapping("/updateService")
		public Service updateService(@RequestBody Service service){
			System.out.println(service);
			return serviceRepository.saveAndFlush(service);
		}
//		 @GetMapping(path = "/updateService/{id}/{categorie}/{description}/{nbr_place}/{nom}/{note}")
//		    public Service updateService(@PathVariable int id, @PathVariable String categorie, @PathVariable String description, @PathVariable int nbr_place, @PathVariable String nom, @PathVariable int note) {
//		        Optional<Service> optService = serviceRepository.findById(id);
//		        Service updateService = serviceRepository.findById(id).get();
//		        if (optService.isPresent()) {
//		            updateService.setCategorie(categorie);
//		            updateService.setDescription(description);
//		            updateService.setNbr_place(nbr_place);
//		            updateService.setNom(nom);
//		            updateService.setNote(note);
//		            return serviceRepository.save(updateService);
//		        } else {
//		            return updateService;
//		        }
//		    }

}
