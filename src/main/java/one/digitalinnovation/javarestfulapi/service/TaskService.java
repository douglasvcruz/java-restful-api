package one.digitalinnovation.javarestfulapi.service;

import one.digitalinnovation.javarestfulapi.domain.model.Task;

public interface TaskService {
    Iterable<Task> getAll();
    Task getById(Long id);
    Task insert(Task task);
    Task update(Long id, Task task);
    void delete(Long id);
}
