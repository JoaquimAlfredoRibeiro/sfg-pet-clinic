package pt.home.sfgpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import pt.home.sfgpetclinic.model.Specialty;

public interface SpecialtyRepository extends CrudRepository<Specialty, Long> {
}
