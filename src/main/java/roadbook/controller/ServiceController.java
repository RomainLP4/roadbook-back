package roadbook.controller;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import roadbook.model.Evenement;
import roadbook.model.Service;
import roadbook.model.Utilisateur;
import roadbook.repository.ServiceRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ServiceController {
    @Autowired
    private ServiceRepository serviceRepository;

    @RequestMapping("/services")
    public Collection<Service> findAll() {

        return serviceRepository.findAll();
    }

    @GetMapping("/serviceById/{id}")
    public Optional<Service> findById(@PathVariable Integer id) {
        return serviceRepository.findById(id);
    }


    @GetMapping("/servicesByCategorie/{categorie}")
    public Collection<Service> findByCategorie(@PathVariable String categorie) {
        return serviceRepository.findAllByCategorieContainingIgnoreCase(categorie);
    }


    @PostMapping("/addService")
    public Service ajoutService(@RequestBody Service service) {
        return serviceRepository.saveAndFlush(service);
    }

    @DeleteMapping("/delService/{id}")
    public void delOne(@PathVariable int id) {
        Optional<Service> optService = serviceRepository.findById(id);
        if (optService.isPresent()) {
            serviceRepository.deleteById(id);
            System.out.println("Action supprimée");
        } else {
            System.out.println("Pas d'action à supprimer");
        }
    }

    //		@PostMapping("/updateService")
//		public Service updateService(@RequestBody Service service){
//			return serviceRepository.saveAndFlush(service);
//		}
//		 @GetMapping(path = "/updateService/{id}/{categorie}/{description}/{nbr_place}/{nom}/{note}")
//		    public Service updateService(@PathVariable int id, @PathVariable String categorie, @PathVariable String description, @PathVariable int nbr_place, @PathVariable String nom, @PathVariable int note) {
//		        Optional<Service> optService = serviceRepository.findById(id);
//		        Service updateService = serviceRepository.findById(id).get();
//		        if (optService.isPresent()) {
//		            updateService.setCategorie(categorie);
//		            updateService.setDescription(description);
//		            updateService.setNbr_place(nbr_place);
//		            updateService.setNom(nom);
//		            updateService.setNote(note);
//		            return serviceRepository.save(updateService);
//		        } else {
//		            return updateService;
//		        }
//		    }
    @PutMapping("/updateService")
    public ResponseEntity<Service> updateService(@RequestBody Service service) {
        // public Utilisateur utilisateurUpdateProfile(@RequestBody Utilisateur utilisateur) {

        Optional<Service> serviceEnBase = serviceRepository.findById(service.getId());


        if (serviceEnBase.isPresent()) {

            // Si l'utilisateur ne renseigne pas certains champs, on leur donne par d�faut leur valeur actuelle plut�t que de les �craser avec un null

            if (service.getCategorie() == null) {                                // id�alement on voudrait utiliser un Optional plut�t qu'un test de null
                service.setCategorie(serviceEnBase.get().getCategorie());        // mais cela supposerait de red�finir la m�thode getPassword de notre
            }                                                                    // Entity comme un Optional. Hors cela apparait incoh�rent avec notre
            if (service.getDescription() == null) {                                // BDD dans laquelle password est NOT NULL.
                service.setDescription(serviceEnBase.get().getDescription());        // Une solution est d'ajouter des data transfer object qui eux disposeraient
            }                                                                    // d'une methode Optional<String> getPassword.
            if (service.getNbr_place() == 0) {
                service.setNbr_place(serviceEnBase.get().getNbr_place());
            }
            if (service.getNom() == null) {
                service.setNom(serviceEnBase.get().getNom());
            }
            if (service.getImage_url() == null) {
                service.setImage_url(serviceEnBase.get().getImage_url());
            }
            if (service.getNote() == 0) {
                service.setNote(serviceEnBase.get().getNote());
            }
            if (service.getRegion() == null) {
                service.setRegion(serviceEnBase.get().getRegion());
            }
            if (service.getUtilisateurs() == null) {
                service.setUtilisateurs(serviceEnBase.get().getUtilisateurs());
            }


            return new ResponseEntity<>(serviceRepository.saveAndFlush(service), HttpStatus.CREATED); // We'll test with HttpStatus.Create

        } else {
            return new ResponseEntity<>(service, HttpStatus.NOT_FOUND);
        }

    }

}
