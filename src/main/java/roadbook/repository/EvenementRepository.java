package roadbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import roadbook.model.Evenement;

@Repository

public interface EvenementRepository extends JpaRepository<Evenement, Integer> {

}
