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
import roadbook.repository.EvenementRepository;



@RestController
public class EvenementController {
	
	@Autowired
	private EvenementRepository evenementRepository;
	
	@GetMapping("/evenements")
	public Collection<Evenement> findAll(){
		return evenementRepository.findAll();
	}
	
	@GetMapping("/evenementById/{id}")
	public Optional<Evenement> findById(@PathVariable Integer id) {
		return evenementRepository.findById(id);
	}
	
	@RequestMapping("/delEvent/{id}")
    public void delOne(@PathVariable int id) {
        Optional<Evenement> optEvent = evenementRepository.findById(id);
        if (optEvent.isPresent()) {
            evenementRepository.deleteById(id);
            System.out.println("Evènement supprimé");
        } else {
            System.out.println("Pas d'évènement avec cet ID");
        }
    }
	@GetMapping("/evenementByNom/{nom}")
	public Optional<Evenement> findByNom(@PathVariable String nom) {
		return evenementRepository.findByNom(nom);
	}
	
	
	/**
	 * Ajoute un evenement
	 */
	@PostMapping("/addEvenement")
	public Evenement ajoutEvenement(@RequestBody Evenement evenement){
		return evenementRepository.saveAndFlush(evenement);
	}
	
	//mettre a jour
//	public Evenement updateEvenement(Evenement evenement){
//		return evenementRepository.saveAndFlush(evenement);
//	}

}