package roadbook.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import roadbook.model.Roadbook;
import roadbook.repository.RoadBookRepository;

@RestController
public class RoadBookController {

	@Autowired
	private RoadBookRepository roadbookRepository;
	
	@GetMapping("/roadbooks")
	public Collection<Roadbook> findAll(){

		return roadbookRepository.findAll();
	}
}
