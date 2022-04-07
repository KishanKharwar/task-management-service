package com.jaza.software.tms.services;

import com.jaza.software.tms.entities.LabelEntity;
import com.jaza.software.tms.entities.TaskEntity;
import com.jaza.software.tms.models.Label;
import com.jaza.software.tms.models.Priority;
import com.jaza.software.tms.models.Task;
import com.jaza.software.tms.repositories.TaskRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

  private TaskRepository repository;

  public Task createTask(Task task) {
    TaskEntity entity = new TaskEntity();
    entity.setTaskName(task.getTaskName());
    entity.setPriority(task.getPriority());
    entity.setDeadLine(task.getDeadLine());

    List<Label> labels = task.getLabels();
    List<LabelEntity> labelEntityList = new ArrayList<>();
    for (Label l : labels) {
      LabelEntity en = new LabelEntity();
      en.setLabelName(l.getLabelName());
      labelEntityList.add(en);
    }
    entity.setLabels(labelEntityList);

    return convertIntoTask(repository.save(entity));
  }

  public Task updateTask(long taskId, Task task) {
    TaskEntity entity = new TaskEntity();
    entity.setTaskId(taskId);
    entity.setTaskName(task.getTaskName());
    entity.setPriority(task.getPriority());
    entity.setDeadLine(task.getDeadLine());

    List<Label> labels = task.getLabels();
    List<LabelEntity> labelEntityList = new ArrayList<>();
    for (Label l : labels) {
      LabelEntity en = new LabelEntity();
      en.setLabelName(l.getLabelName());
      labelEntityList.add(en);
    }
    entity.setLabels(labelEntityList);

    return convertIntoTask(repository.save(entity));
  }

  public boolean removeTask(long taskId) {
    repository.deleteById(taskId);
    Optional<TaskEntity> op = repository.findById(taskId);
    return op.isEmpty();
  }

  public List<Task> getAllTasks() {
    List<Task> taskList = new ArrayList<>();
    List<TaskEntity> taskEntities = null;
    taskEntities = repository.findAll();

    for (TaskEntity entity : taskEntities) {
      Task task = convertIntoTask(entity);
      taskList.add(task);
    }
    return taskList;
  }

  public List<Task> getAllTasksByPriority(Priority priority) {
    List<Task> taskList = new ArrayList<>();
    List<TaskEntity> taskEntities = null;
    taskEntities = repository.findByPriority(priority);
    for (TaskEntity entity : taskEntities) {
      Task task = convertIntoTask(entity);
      taskList.add(task);
    }
    return taskList;
  }

  public List<Task> getAllTodaysTasksByLabel(String label) {
    List<Task> taskList = new ArrayList<>();
    List<TaskEntity> taskEntities = null;
    taskEntities = repository
        .findByLabelsAndDeadLine(label, 0); // passing deadLine=0 for today's task
    for (TaskEntity entity : taskEntities) {
      Task task = convertIntoTask(entity);
      taskList.add(task);
    }
    return taskList;
  }

  public List<Task> getAllNextTwoDaysTasks() {
    List<Task> taskList = new ArrayList<>();
    List<TaskEntity> taskEntities = null;
    taskEntities = repository.findByDeadLineBetween(0,
        2); // passing deadLineStart=0 and deadLineEnd=2 for two days of  tasks
    for (TaskEntity entity : taskEntities) {
      Task task = convertIntoTask(entity);
      taskList.add(task);
    }
    return taskList;
  }

  public Task convertIntoTask(TaskEntity taskEntity) {
    List<LabelEntity> labelEntities = taskEntity.getLabels();
    List<Label> labels = new ArrayList<>();
    for (LabelEntity en : labelEntities) {
      Label label = new Label(en.getLabelName());
      labels.add(label);
    }
    Task task = new Task(taskEntity.getTaskId(), taskEntity.getTaskName(), taskEntity.getPriority(),
        taskEntity.getDeadLine(), labels);
    return task;
  }


  @Autowired
  public void setRepository(TaskRepository repository) {
    this.repository = repository;
  }


}
