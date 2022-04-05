package com.jaza.software.tms.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "labels")
public class LabelEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private long labelId;
  private String labelName;
  @ManyToOne(fetch = FetchType.LAZY,optional = false)
  @JoinColumn(name = "task_id",nullable = false)
  @OnDelete(action = OnDeleteAction.CASCADE)
  private TaskEntity task;

  public LabelEntity() {

  }

  public LabelEntity(long labelId, String labelName, TaskEntity task) {
    this.labelId = labelId;
    this.labelName = labelName;
    this.task = task;
  }

  public long getLabelId() {
    return labelId;
  }

  public void setLabelId(long labelId) {
    this.labelId = labelId;
  }

  public String getLabelName() {
    return labelName;
  }

  public void setLabelName(String labelName) {
    this.labelName = labelName;
  }

  public TaskEntity getTask() {
    return task;
  }

  public void setTask(TaskEntity task) {
    this.task = task;
  }

  @Override
  public String toString() {
    return "LabelEntity{" +
        "labelId=" + labelId +
        ", labelName='" + labelName + '\'' +
        ", task=" + task +
        '}';
  }
}
