package com.jaza.software.tms.entities;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "labels")
public class LabelEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  @Column(name = "label_id")
  private long labelId;
  private String labelName;

  @ManyToMany(mappedBy = "labels")
  private List<TaskEntity> tasks;

  public LabelEntity() {

  }

  public LabelEntity(String labelName) {
    this.labelName = labelName;

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

  public List<TaskEntity> getTasks() {
    return tasks;
  }

  public void setTasks(List<TaskEntity> tasks) {
    this.tasks = tasks;
  }

  @Override
  public String toString() {
    return "LabelEntity{" +
        "labelId=" + labelId +
        ", labelName='" + labelName + '\'' +
        ", tasks=" + tasks +
        '}';
  }
}