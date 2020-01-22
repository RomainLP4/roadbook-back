package roadbook.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import roadbook.model.Region;
import roadbook.repository.RegionRepository;

@RestController
public class RegionController {

	@Autowired
	private RegionRepository regionRepository;
	
	@GetMapping("/regions")
	public Collection<Region> findAll(){

		return regionRepository.findAll();
	}
}
