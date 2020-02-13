package roadbook.controller;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import roadbook.model.Evenement;
import roadbook.model.Region;
import roadbook.repository.RegionRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class RegionController {

	@Autowired
	private RegionRepository regionRepository;
	
	@GetMapping("/regions")
	public Collection<Region> findAll(){

		return regionRepository.findAll();
	}
	@GetMapping("/regionById/{id}")
	public Optional<Region> findById(@PathVariable Integer id) {
		return regionRepository.findById(id);
	}
}
