package com.jaza.software.tms.controller;

import com.jaza.software.tms.models.Priority;
import com.jaza.software.tms.models.Task;
import com.jaza.software.tms.services.TaskService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/task")
public class TaskController {

  private TaskService service;

  @PostMapping
  public ResponseEntity<Task> createTask(@RequestBody Task task) {
    Task createdTask = service.createTask(task);
    return new ResponseEntity<Task>(createdTask, HttpStatus.CREATED);
  }

  @PutMapping("/{taskId}")
  public ResponseEntity<Task> updateTask(@PathVariable long taskId, @RequestBody Task task) {
    Task updatedTask = service.updateTask(taskId, task);
    return new ResponseEntity<Task>(updatedTask, HttpStatus.CREATED);
  }

  @DeleteMapping("/{taskId}")
  public ResponseEntity<Long> deleteTask(@PathVariable long taskId) {
    boolean isRemoved = service.removeTask(taskId);

    if (!isRemoved) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    return new ResponseEntity<>(taskId, HttpStatus.OK);
  }

  @GetMapping
  public ResponseEntity<List<Task>> getAllTasks() {
    List<Task> taskList = service.getAllTasks();

    if (taskList.isEmpty()) {
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    return new ResponseEntity<>(taskList, HttpStatus.OK);
  }

  @GetMapping("/priority/{priorityType}")
  public ResponseEntity<List<Task>> getTaskByPriority(@PathVariable Priority priorityType) {

    List<Task> taskList = service.getAllTasksByPriority(priorityType);

    if (taskList.isEmpty()) {
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    return new ResponseEntity<>(taskList, HttpStatus.OK);
  }

  @GetMapping("/label/{labelName}")
  public ResponseEntity<List<Task>> getTodaysTaskByLabel(@PathVariable String labelName) {
    List<Task> taskList = service.getAllTodaysTasksByLabel(labelName);

    if (taskList.isEmpty()) {
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    return new ResponseEntity<>(taskList, HttpStatus.OK);
  }

  @GetMapping("/get-next-two-days-task")
  public ResponseEntity<List<Task>> getTodaysTaskByLabel() {
    List<Task> taskList = service.getAllNextTwoDaysTasks();

    if (taskList.isEmpty()) {
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    return new ResponseEntity<>(taskList, HttpStatus.OK);
  }

  @GetMapping("/test")
  public String test() {
    return "testing";
  }


  @Autowired
  public void setService(TaskService service) {
    this.service = service;
  }
}
