package one.digitalinnovation.javarestfulapi.domain.repository;

import one.digitalinnovation.javarestfulapi.domain.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long>  {
}
