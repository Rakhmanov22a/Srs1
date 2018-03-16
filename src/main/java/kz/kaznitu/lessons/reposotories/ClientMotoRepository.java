package kz.kaznitu.lessons.reposotories;

import kz.kaznitu.lessons.models.ClientMoto;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ClientMotoRepository extends CrudRepository<ClientMoto,Long> {
    Optional<ClientMoto> findById(Long id);
}
