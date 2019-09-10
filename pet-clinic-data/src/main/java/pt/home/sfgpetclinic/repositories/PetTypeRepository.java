package pt.home.sfgpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import pt.home.sfgpetclinic.model.PetType;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
