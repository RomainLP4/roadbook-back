package roadbook.repository;

import java.util.Collection;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import roadbook.model.Evenement;
import roadbook.model.Utilisateur;

@Repository

public interface EvenementRepository extends JpaRepository<Evenement, Integer> {

	public Optional<Evenement> findByNom(String nom);
	public Collection<Evenement> findAllByNom(String nom);
	
	public Optional<Evenement> findByType(String type);
	public Collection<Evenement> findAllByType(String type);
	
}
