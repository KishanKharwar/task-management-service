package com.jaza.software.tms.models;

import java.sql.Timestamp;

public class Task {
  private String taskName;
  private Priority priority;
  private Timestamp deadLine;

  public Task(String taskName, Priority priority, Timestamp deadLine) {
    this.taskName = taskName;
    this.priority = priority;
    this.deadLine = deadLine;
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

  public Timestamp getDeadLine() {
    return deadLine;
  }

  public void setDeadLine(Timestamp deadLine) {
    this.deadLine = deadLine;
  }

  @Override
  public String toString() {
    return "Task{" +
        "taskName='" + taskName + '\'' +
        ", priority=" + priority +
        ", deadLine=" + deadLine +
        '}';
  }
}
