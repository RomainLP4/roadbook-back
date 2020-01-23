package roadbook.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import roadbook.model.Moto;
import roadbook.model.Service;

@Repository
public interface MotoRepository extends CrudRepository<Moto, Integer> {

	Moto saveAndFlush(Moto moto);



}
