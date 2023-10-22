package one.digitalinnovation.javarestfulapi.service.impl;

import one.digitalinnovation.javarestfulapi.domain.model.Task;
import one.digitalinnovation.javarestfulapi.domain.repository.PersonRepository;
import one.digitalinnovation.javarestfulapi.domain.repository.TaskRepository;
import one.digitalinnovation.javarestfulapi.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private PersonRepository personRepository;
    @Override
    public Iterable<Task> getAll() {
        return taskRepository.findAll();
    }

    @Override
    public Task getById(Long id) {
        Optional<Task> task = taskRepository.findById(id);
        return task.orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Task insert(Task task) {
        personRepository.save(task.getPerson());
        return taskRepository.save(task);
    }

    @Override
    public Task update(Long id, Task task) {
        Task taskById = taskRepository.findById(id).get();
        taskById.setTitle(task.getTitle());
        taskById.setDescription(task.getDescription());
        taskById.setCompleted(task.isCompleted());
        taskById.setPerson(task.getPerson());
        taskById.getPerson().setId(id);
        personRepository.save(taskById.getPerson());
        return taskRepository.save(taskById);
    }

    @Override
    public void delete(Long id) {
        taskRepository.deleteById(id);
    }
}
