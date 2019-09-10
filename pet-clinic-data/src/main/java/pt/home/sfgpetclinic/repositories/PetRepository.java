package pt.home.sfgpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import pt.home.sfgpetclinic.model.Pet;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
