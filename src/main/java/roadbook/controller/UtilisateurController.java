package roadbook.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
}
