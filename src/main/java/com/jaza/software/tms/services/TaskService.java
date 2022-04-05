package com.jaza.software.tms.services;

import com.jaza.software.tms.entities.TaskEntity;
import com.jaza.software.tms.models.Task;
import com.jaza.software.tms.repositories.TaskRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

  @Autowired
  private TaskRepository repository;

  public List<Task> getAllTasks(){
    List<Task> taskList = new ArrayList<>();
    List<TaskEntity> taskEntities = null;
    taskEntities = repository.findAll();
    for(TaskEntity entity : taskEntities){
      taskList.add(new Task(entity.getTaskName(),entity.getPriority(),entity.getDeadLine()));
    }
    return taskList;
  }
//  @Autowired
//  public void setRepository(TaskRepository repository) {
//    this.repository = repository;
//  }
}
