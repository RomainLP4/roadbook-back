package roadbook.controller;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import roadbook.model.Utilisateur;
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
	
	/*
	@PostMapping("/utilisateurUpdateProfile")
	public Utilisateur saveOrUpdateUtilisateur(@RequestBody Utilisateur utilisateur) {
		return saveOrUpdateUtilisateur(utilisateur);
	}
	*/
	
	@PostMapping("/utilisateurUpdateProfile")
	public Utilisateur utilisateurUpdateProfile(@RequestBody Utilisateur utilisateur) {

		
		Optional<Utilisateur> utilisateurEnBase = utilisateurRepository.findById(utilisateur.getId());
		
		
		
		if(utilisateurEnBase.isPresent()) {
		System.out.println(" on est entré dans le if statement, un save devrait avoir lieu");
			
			// Si l'utilisateur ne renseigne pas certains champs, on leur donne par défaut leur valeur actuelle plutôt que de les écraser avec un null
		
			if(utilisateur.getPseudo() == null) {								// idéalement on voudrait utiliser un Optional plutôt qu'un test de null
				utilisateur.setPseudo(utilisateurEnBase.get().getPseudo());		// mais cela supposerait de redéfinir la méthode getPassword de notre 
			}																	// Entity comme un Optional. Hors cela apparait incohérent avec notre
			if(utilisateur.getEmail() == null) {								// BDD dans laquelle password est NOT NULL.
				utilisateur.setEmail(utilisateurEnBase.get().getEmail());		// Une solution est d'ajouter des data transfer object qui eux disposeraient
			}																	// d'une methode Optional<String> getPassword.
			if(utilisateur.getPassword() == null) {
				utilisateur.setPassword(utilisateurEnBase.get().getPassword());
			}
			if(utilisateur.getNom() == null) {
				utilisateur.setNom(utilisateurEnBase.get().getNom());
			}
			if(utilisateur.getPrenom() == null) {
				utilisateur.setPrenom(utilisateurEnBase.get().getPrenom());
			}
			if(utilisateur.getTelephone() == null) {
				utilisateur.setTelephone(utilisateurEnBase.get().getTelephone());
			}
			if(utilisateur.getNiveau() == null) {
				utilisateur.setNiveau(utilisateurEnBase.get().getNiveau());
			}
			if(utilisateur.getVille() == null) {
				utilisateur.setVille(utilisateurEnBase.get().getVille());
			}
			
			// No if statement here because the update profile endpoint shouldn't allow modifying its admin rights.
			utilisateur.setRole(utilisateurEnBase.get().getRole());
		
			
			return utilisateurRepository.saveAndFlush(utilisateur);
	
		} else {
			System.out.println("utilisateurEnBase !isPresent");
			return utilisateur;
		}
		
		//return utilisateur;
		//utilisa
		//return utilisateurRepository.saveAndFlush(utilisateur);
	}
	
}
