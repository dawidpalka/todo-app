package pl.dawidpalka.todoapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import pl.dawidpalka.todoapp.model.Task;
import pl.dawidpalka.todoapp.model.TaskRepository;

import java.util.List;


@RepositoryRestController
public class TaskController {
    private static final Logger logger = LoggerFactory.getLogger(TaskController.class);
    private final TaskRepository taskRepository;

    public TaskController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @GetMapping(path = "/tasks", params = {"!sort", "!page", "!size"})
    ResponseEntity<List<Task>> readAllTasks() {
        logger.warn("Exposing all the tasks!");
        return ResponseEntity.ok(taskRepository.findAll());
    }

    @GetMapping(path = "/tasks")
    ResponseEntity<List<Task>> readAllTasks(Pageable page) {
        logger.info("Custom pageable!");
//        return ResponseEntity.ok(taskRepository.findAll(page)); //Getting more information about Pageable and Sortable
        return ResponseEntity.ok(taskRepository.findAll(page).getContent());
    }
}
