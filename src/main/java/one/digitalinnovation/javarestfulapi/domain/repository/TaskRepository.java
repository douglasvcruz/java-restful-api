package one.digitalinnovation.javarestfulapi.domain.repository;

import one.digitalinnovation.javarestfulapi.domain.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
}
