package roadbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import roadbook.model.RoadBook;

@Repository

public interface RoadBookRepository extends JpaRepository<RoadBook, Integer> {

}
