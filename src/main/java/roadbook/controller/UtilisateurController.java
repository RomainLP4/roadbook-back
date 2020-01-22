package roadbook.controller;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	//@PostMapping("/")
	
	
}
