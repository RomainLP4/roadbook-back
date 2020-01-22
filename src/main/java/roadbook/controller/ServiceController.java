package roadbook.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import roadbook.model.Service;
import roadbook.repository.ServiceRepository;

@RestController
@CrossOrigin("*")
public class ServiceController {
	@Autowired
	private ServiceRepository serviceRepository;
	
	@GetMapping("/service")
	public Collection<Service> findAll(){
		return serviceRepository.findAll();
	}
}
