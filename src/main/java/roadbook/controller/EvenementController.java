package roadbook.controller;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import roadbook.model.Evenement;
import roadbook.model.Service;
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
            System.out.println("Evénement supprimé");
        } else {
            System.out.println("Pas d'événement avec cet ID");
        }
    }
	
	/**
	 * Recherche par nom d'événement
	 */
	@GetMapping("/evenementByNom/{nom}")
	public Optional<Evenement> findByNom(@PathVariable String nom) {
		return evenementRepository.findByNom(nom);
	}
	
	/**
	 * Recherche par nom si plusieurs fois le même nom
	 */
	@GetMapping("/evenementByNoms/{nom}")
	public Collection<Evenement> findAllByNom(@PathVariable String nom) {
		return evenementRepository.findAllByNom(nom);
	}
	
	/**
	 * Recherche par type d'événement
	 */
	@GetMapping("/evenementByType/{type}")
	public Optional<Evenement> findByType(@PathVariable String type) {
		return evenementRepository.findByType(type);
	}
	
	/**
	 * Recherche par type d'événement si plusieurs
	 */
	@GetMapping("/evenementByTypes/{type}")
	public Collection<Evenement> findAllByType(@PathVariable String type) {
		return evenementRepository.findAllByType(type);
	}
	
	
	
	/**
	 * Ajoute un évènement
	 */
	@PostMapping("/addEvenement")
	public Evenement ajoutEvenement(@RequestBody Evenement evenement){
		return evenementRepository.saveAndFlush(evenement);
	}
	
	/**
	 * mettre a jour
	 */
//	@PostMapping("/updateEvenement")
//	public Evenement updateEvenement(@RequestBody Evenement evenement){
//		System.out.println(evenement);
//		return evenementRepository.saveAndFlush(evenement);
//	}
	
	@PostMapping("/updateEvenement")
	public ResponseEntity<Evenement> updateEvenement(@RequestBody Evenement evenement) {
		
		Optional<Evenement> evenementEnBase = evenementRepository.findById(evenement.getId());
		
		
		if(evenementEnBase.isPresent()) {
		
			// Si l'utilisateur ne renseigne pas certains champs, on leur donne par défaut leur valeur actuelle plutôt que de les écraser avec un null
		
			if(evenement.getType() == null) {								// id�alement on voudrait utiliser un Optional plut�t qu'un test de null
				evenement.setType(evenementEnBase.get().getType());		// mais cela supposerait de red�finir la m�thode getPassword de notre 
			}																	// Entity comme un Optional. Hors cela apparait incoh�rent avec notre
			if(evenement.getDescription() == null) {								// BDD dans laquelle password est NOT NULL.
				evenement.setDescription(evenementEnBase.get().getDescription());		// Une solution est d'ajouter des data transfer object qui eux disposeraient
			}																	// d'une methode Optional<String> getPassword.
			if(evenement.getNom() == null) {
				evenement.setNom(evenementEnBase.get().getNom());
			}
			if(evenement.getDate() == null) {
				evenement.setDate(evenementEnBase.get().getDate());
			}
			if(evenement.getRegion() == null) {
				evenement.setRegion(evenementEnBase.get().getRegion());
			}
			if(evenement.getUtilisateur() == null) {
				evenement.setUtilisateur(evenementEnBase.get().getUtilisateur());
			}
			if(evenement.getRoadbook() == null) {
				evenement.setRoadbook(evenementEnBase.get().getRoadbook());
			}
			
			
			
		
			return new ResponseEntity<>(evenementRepository.saveAndFlush(evenement), HttpStatus.CREATED); // We'll test with HttpStatus.Create
	
		} else {
			return new ResponseEntity<>(evenement, HttpStatus.NOT_FOUND);
		}

	}

}