package com.jaza.software.tms.models;

import java.util.Calendar;
import java.util.List;

public class Task {
  private long taskId;
  private String taskName;
  private Priority priority;
  private Integer deadLine;
  private List<Label> labels;

  public Task() {

  }

  public Task(String taskName, Priority priority, Integer deadLine,
      List<Label> labels) {
    this.taskName = taskName;
    this.priority = priority;
    this.deadLine = deadLine;
    this.labels = labels;
  }

  public Task(long taskId,String taskName, Priority priority, Integer deadLine,
      List<Label> labels) {
    this.taskId = taskId;
    this.taskName = taskName;
    this.priority = priority;
    this.deadLine = deadLine;
    this.labels = labels;
  }

  public String getTaskName() {
    return taskName;
  }

  public void setTaskName(String taskName) {
    this.taskName = taskName;
  }

  public Priority getPriority() {
    return priority;
  }

  public void setPriority(Priority priority) {
    this.priority = priority;
  }

  public Integer getDeadLine() {
    return deadLine;
  }

  public void setDeadLine(Integer deadLine) {
    this.deadLine = deadLine;
  }

  public List<Label> getLabels() {
    return labels;
  }

  public void setLabels(List<Label> labels) {
    this.labels = labels;
  }

  public long getTaskId() {
    return taskId;
  }

  public void setTaskId(long taskId) {
    this.taskId = taskId;
  }

  @Override
  public String toString() {
    return "Task{" +
        "taskName='" + taskName + '\'' +
        ", priority=" + priority +
        ", deadLine=" + deadLine +
        ", labels=" + labels +
        '}';
  }
}
