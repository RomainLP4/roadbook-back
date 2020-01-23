package roadbook.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import roadbook.model.Moto;
import roadbook.model.Service;
import roadbook.repository.MotoRepository;

@RestController
public class MotoController {
	@Autowired
	private MotoRepository motoRepository;
	
	@GetMapping("/motos")
	public Iterable<Moto> findAll(){

		return motoRepository.findAll();
	}

	@PostMapping("/addMoto")
    public Moto ajoutMoto(@RequestBody Moto moto){
        return motoRepository.saveAndFlush(moto);
    }
	
	
	@RequestMapping("/delMoto/{id}")
    public void delOne(@PathVariable int id) {
        Optional<Moto> optMoto = motoRepository.findById(id);
        if (optMoto.isPresent()) {
            motoRepository.deleteById(id);
            System.out.println("Moto supprimée");
        } else {
            System.out.println("Pas de moto avec cet ID");
        }
    }
}

