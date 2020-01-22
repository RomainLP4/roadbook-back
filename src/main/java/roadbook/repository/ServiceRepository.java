package roadbook.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import roadbook.model.Service;
@Repository
public interface ServiceRepository extends JpaRepository<Service, Integer> {
	public Optional<Service> findByCategorie(String categorie);
}
