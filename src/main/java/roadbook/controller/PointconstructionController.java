package roadbook.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
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
	@RequestMapping("/delEtape/{id}")
    public void delOne(@PathVariable int id) {
        Optional<Pointconstruction> optEtape = pointconstructionRepository.findById(id);
        if (optEtape.isPresent()) {
          pointconstructionRepository.deleteById(id);
            System.out.println("Point de construction supprimé");
        } else {
            System.out.println("Pas de point de construction avec cet ID");
        }
    }

}
