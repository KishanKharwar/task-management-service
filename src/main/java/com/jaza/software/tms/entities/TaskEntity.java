package com.jaza.software.tms.entities;

import com.jaza.software.tms.models.Priority;
import com.jaza.software.tms.models.Task;
import java.sql.Timestamp;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="tasks")
public class TaskEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long taskId;
  private String taskName;
  private Priority priority;
  private Timestamp deadLine;
  private Timestamp createDate;

  public TaskEntity(){

  }
  public TaskEntity(long taskId, String taskName, Priority priority, Timestamp deadLine,
      Timestamp createDate) {
    this.taskId = taskId;
    this.taskName = taskName;
    this.priority = priority;
    this.deadLine = deadLine;
    this.createDate = createDate;
  }

  public long getTaskId() {
    return taskId;
  }

  public void setTaskId(long taskId) {
    this.taskId = taskId;
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

  public Timestamp getCreateDate() {
    return createDate;
  }

  public void setCreateDate(Timestamp createDate) {
    this.createDate = createDate;
  }

  @Override
  public String toString() {
    return "TaskEntity{" +
        "taskId=" + taskId +
        ", taskName='" + taskName + '\'' +
        ", priority=" + priority +
        ", deadLine=" + deadLine +
        ", createDate=" + createDate +
        '}';
  }
}
