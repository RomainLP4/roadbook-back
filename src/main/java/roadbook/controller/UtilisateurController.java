package roadbook.controller;

import java.net.http.HttpRequest;
import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import roadbook.model.Utilisateur;
import roadbook.repository.UtilisateurRepository;

@RestController
@RequestMapping("/utilisateur")
@CrossOrigin(origins = "http://localhost:4200")
public class UtilisateurController {
	
	@Autowired
	private UtilisateurRepository utilisateurRepository;
	
	@GetMapping("/all")
	public Collection<Utilisateur> findAll(){
		return utilisateurRepository.findAll();
	}
	
	@GetMapping("/byId/{id}")
	public Optional<Utilisateur> findById(@PathVariable Integer id) {
		return utilisateurRepository.findById(id);
	}
	
	@GetMapping("/byPseudo/{pseudo}")
	public Optional<Utilisateur> findByPseudo(@PathVariable String pseudo) {
		return utilisateurRepository.findByPseudo(pseudo);
	}
	
	@GetMapping("/byEmailCheckPassword/{email}/{pw}")			// A REMPLACER - ABSOLUMENT PAS SECURISE (passer par un service d'encodage jwt)
	public ResponseEntity<Utilisateur> attemptLogin(@PathVariable("email") String email, @PathVariable("pw") String pw){
		System.out.println("Repo consulté pour email : " + email + " et password : " +pw);
		
		
		Optional<Utilisateur> utilisateurEnBase = utilisateurRepository.findByEmail(email);
		
		if(utilisateurEnBase.isPresent()) {
			System.out.println("utilisateur trouvé pour : " + email);
			Utilisateur utlisateurPresentEnBase = utilisateurEnBase.get();
			
			if(utlisateurPresentEnBase.getPassword().equals(pw)){
				return new ResponseEntity<Utilisateur>(utlisateurPresentEnBase, HttpStatus.OK);
			} else {
				System.out.println("else from inner 'if' statement");
				return new ResponseEntity<Utilisateur>(HttpStatus.NOT_FOUND); // se documenter sur HttpStatus.UNAUTHORIZED 
			}
			
		} else {
			System.out.println("else from outer 'if' statement");
			return new ResponseEntity<Utilisateur>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/save")
	public ResponseEntity<Utilisateur> saveUtilisateur(@RequestBody Utilisateur utilisateur) {
		
		if(utilisateur.getPseudo().isEmpty() || utilisateur.getEmail().isEmpty() || utilisateur.getPassword().isEmpty()) {
			return new ResponseEntity<>(utilisateur, HttpStatus.BAD_REQUEST);
		} else {
			utilisateur.setRole("Utilisateur");
			return new ResponseEntity<>(utilisateurRepository.save(utilisateur), HttpStatus.CREATED);
		}
	}
	
	
	@PostMapping("/updateProfile")
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
	
	@RequestMapping("/del/{id}")
    public void delOne(@PathVariable int id) {
        Optional<Utilisateur> optUser = utilisateurRepository.findById(id);
        if (optUser.isPresent()) {
            utilisateurRepository.deleteById(id);
            System.out.println("Utilisateur supprimÃ©");
        } else {
            System.out.println("Pas d'utilisateur avec cet ID");
        }
    }
}
