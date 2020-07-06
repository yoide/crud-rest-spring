package springprojects.springcrud.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import springprojects.springcrud.entities.Auto;

@Repository
public interface AutoRepository extends CrudRepository<Auto, Long> {
}
