package roadbook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import roadbook.model.Moto;
import roadbook.repository.MotoRepository;

@RestController
public class MotoController {
	@Autowired
	private MotoRepository motoRepository;
	
	@GetMapping("/motos")
	public Iterable<Moto> findAll(){

		return motoRepository.findAll();
	}

}

