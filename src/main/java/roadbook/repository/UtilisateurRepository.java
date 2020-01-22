package roadbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import roadbook.model.Utilisateur;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Integer> {

}
