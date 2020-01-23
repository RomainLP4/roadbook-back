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

import roadbook.model.Utilisateur;
import roadbook.model.enums.Role;
import roadbook.repository.UtilisateurRepository;

@RestController
public class UtilisateurController {
	
	@Autowired
	private UtilisateurRepository utilisateurRepository;
	
	@GetMapping("/utilisateurs")
	public Collection<Utilisateur> findAll(){
		return utilisateurRepository.findAll();
	}
	
	@GetMapping("/utilisateurById/{id}")
	public Optional<Utilisateur> findById(@PathVariable Integer id) {
		return utilisateurRepository.findById(id);
	}
	
	@GetMapping("/utilisateurByPseudo/{pseudo}")
	public Optional<Utilisateur> findByPseudo(@PathVariable String pseudo) {
		return utilisateurRepository.findByPseudo(pseudo);
	}
	
	
	@PostMapping("/utilisateurSave")
	public ResponseEntity<Utilisateur> saveUtilisateur(@RequestBody Utilisateur utilisateur) {
		
		if(utilisateur.getPseudo().isEmpty() || utilisateur.getEmail().isEmpty() || utilisateur.getPassword().isEmpty()) {
			return new ResponseEntity<>(utilisateur, HttpStatus.BAD_REQUEST);
		} else {
			//utilisateur.setRole(Role.Utilisateur);
			utilisateur.setRole("Utilisateur");
			return new ResponseEntity<>(utilisateurRepository.save(utilisateur), HttpStatus.CREATED);
		}
	}
	
	
	@PostMapping("/utilisateurUpdateProfile")
	public ResponseEntity<Utilisateur> utilisateurUpdateProfile(@RequestBody Utilisateur utilisateur) {
	// public Utilisateur utilisateurUpdateProfile(@RequestBody Utilisateur utilisateur) {
		
		Optional<Utilisateur> utilisateurEnBase = utilisateurRepository.findById(utilisateur.getId());
		
		
		if(utilisateurEnBase.isPresent()) {
			Utilisateur utilisateurPresentEnBase = utilisateurEnBase.get();
		
			// Si l'utilisateur ne renseigne pas certains champs, on leur donne par defaut leur valeur actuelle plutot que de les ecraser avec un null
		
			if(utilisateur.getPseudo().isEmpty()) {								
				utilisateur.setPseudo(utilisateurPresentEnBase.getPseudo());		
			}																	
			if(utilisateur.getEmail().isEmpty()) {								
				utilisateur.setEmail(utilisateurPresentEnBase.getEmail());		
			}																	
			if(utilisateur.getPassword().isEmpty()) {
				utilisateur.setPassword(utilisateurPresentEnBase.getPassword());
			}
			if(utilisateur.getNom().isEmpty()) {
				utilisateur.setNom(utilisateurPresentEnBase.getNom());
			}
			if(utilisateur.getPrenom().isEmpty()) {
				utilisateur.setPrenom(utilisateurPresentEnBase.getPrenom());
			}
			if(utilisateur.getTelephone().isEmpty()) {
				utilisateur.setTelephone(utilisateurPresentEnBase.getTelephone());
			}
			if(utilisateur.getNiveau().isEmpty()) {
				utilisateur.setNiveau(utilisateurPresentEnBase.getNiveau());
			}
			if(utilisateur.getVille().isEmpty()) {
				utilisateur.setVille(utilisateurPresentEnBase.getVille());
			}
			// No if statement here because the update profile endpoint shouldn't allow modifying its admin rights.
			utilisateur.setRole(utilisateurEnBase.get().getRole());
		
			return new ResponseEntity<>(utilisateurRepository.saveAndFlush(utilisateur), HttpStatus.CREATED); // We'll test with HttpStatus.Create
	
		} else {
			return new ResponseEntity<>(utilisateur, HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping("/delUser/{id}")
    public void delOne(@PathVariable int id) {
        Optional<Utilisateur> optUser = utilisateurRepository.findById(id);
        if (optUser.isPresent()) {
            utilisateurRepository.deleteById(id);
            System.out.println("Utilisateur supprimé");
        } else {
            System.out.println("Pas d'utilisateur avec cet ID");
        }
    }
}
