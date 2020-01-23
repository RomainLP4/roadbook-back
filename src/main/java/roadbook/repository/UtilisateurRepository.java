package roadbook.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import roadbook.model.Utilisateur;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Integer> {
	
		public Optional<Utilisateur> findByPseudo(String pseudo);
		
		//public Utilisateur saveOrUpdateUtilisateur(Utilisateur utilisateur);
		public Utilisateur saveAndFlush(Utilisateur utilisateur);
}
