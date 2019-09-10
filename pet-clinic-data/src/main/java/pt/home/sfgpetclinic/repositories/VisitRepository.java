package pt.home.sfgpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import pt.home.sfgpetclinic.model.Visit;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
