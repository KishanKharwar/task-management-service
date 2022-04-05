package com.jaza.software.tms.models;

public class Label {
  private String labelName;
  private Task task;

  public Label(String labelName, Task task) {
    this.labelName = labelName;
    this.task = task;
  }

  public String getLabelName() {
    return labelName;
  }

  public void setLabelName(String labelName) {
    this.labelName = labelName;
  }

  public Task getTask() {
    return task;
  }

  public void setTask(Task task) {
    this.task = task;
  }

  @Override
  public String toString() {
    return "Label{" +
        "labelName='" + labelName + '\'' +
        ", task=" + task +
        '}';
  }
}
