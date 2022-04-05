package com.jaza.software.tms.controller;

import com.jaza.software.tms.models.Task;
import com.jaza.software.tms.services.TaskService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TaskController {

  private TaskService service;

  @GetMapping("/test")
  public String test(){
    return "testing";
  }

  @GetMapping("/tasks")
  public ResponseEntity<List<Task>> getAllTasks(){
    List<Task> taskList = service.getAllTasks();

    if(taskList.isEmpty()){
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @Autowired
  public void setService(TaskService service) {
    this.service = service;
  }
}
