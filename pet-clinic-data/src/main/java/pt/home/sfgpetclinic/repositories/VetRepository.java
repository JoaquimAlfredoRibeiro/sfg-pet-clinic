package pt.home.sfgpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import pt.home.sfgpetclinic.model.Vet;

public interface VetRepository extends CrudRepository<Vet, Long> {
}
