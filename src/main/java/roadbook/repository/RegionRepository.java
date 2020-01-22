package roadbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import roadbook.model.Region;

@Repository
public interface RegionRepository extends JpaRepository<Region, Integer>{

}
