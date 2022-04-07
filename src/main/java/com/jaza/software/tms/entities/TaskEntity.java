package com.jaza.software.tms.entities;

import com.jaza.software.tms.models.Priority;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tasks")
public class TaskEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "task_id")
  private long taskId;
  private String taskName;
  private Priority priority;
  private Integer deadLine;
  private Timestamp createDate;
  @ManyToMany(cascade = CascadeType.ALL)
  @JoinTable(name = "tasks_labels", joinColumns = @JoinColumn(name = "task_id", referencedColumnName = "task_id"), inverseJoinColumns = @JoinColumn(name = "label_id", referencedColumnName = "label_id"))
  private List<LabelEntity> labels;

  public TaskEntity() {

  }

  public TaskEntity( String taskName, Priority priority, Integer deadLine,
      Timestamp createDate, List<LabelEntity> labels) {
    this.taskName = taskName;
    this.priority = priority;
    this.deadLine = deadLine;
    this.createDate = createDate;
    this.labels = labels;
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

  public Integer getDeadLine() {
    return deadLine;
  }

  public void setDeadLine(Integer deadLine) {
    this.deadLine = deadLine;
  }

  public Timestamp getCreateDate() {
    return createDate;
  }

  public void setCreateDate(Timestamp createDate) {
    this.createDate = createDate;
  }

  public List<LabelEntity> getLabels() {
    return labels;
  }

  public void setLabels(List<LabelEntity> labels) {
    this.labels = labels;
  }

  @Override
  public String toString() {
    return "TaskEntity{" +
        "taskId=" + taskId +
        ", taskName='" + taskName + '\'' +
        ", priority=" + priority +
        ", deadLine=" + deadLine +
        ", createDate=" + createDate +
        ", labels=" + labels +
        '}';
  }
}
