package roadbook.controller;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
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
	
	@RequestMapping("/delRoadbook/{id}")
    public void delOne(@PathVariable int id) {
        Optional<Roadbook> optRoadbook = roadbookRepository.findById(id);
        if (optRoadbook.isPresent()) {
          roadbookRepository.deleteById(id);
            System.out.println("Roadbook supprimé");
        } else {
            System.out.println("Pas de roadbook avec cet ID");
        }
    }
}

