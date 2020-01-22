package roadbook.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
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
}
