package roadbook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import roadbook.model.Pointconstruction;
import roadbook.repository.PointconstructionRepository;

@RestController
public class PointconstructionController {
	
	@Autowired
	private PointconstructionRepository pointconstructionRepository;
	
	@GetMapping("/etapes")
	public Iterable<Pointconstruction> findAll(){
		return pointconstructionRepository.findAll();
	
	}

}
