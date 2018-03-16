package kz.kaznitu.lessons.reposotories;

import kz.kaznitu.lessons.models.AdminMoto;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AdminMotoRepository extends CrudRepository<AdminMoto, Long> {
    Optional<AdminMoto> findById(Long id);
}
