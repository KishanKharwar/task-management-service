package com.jaza.software.tms.models;

public class Label {
  private String labelName;

  public Label(String labelName) {
    this.labelName = labelName;
  }

  public String getLabelName() {
    return labelName;
  }

  public void setLabelName(String labelName) {
    this.labelName = labelName;
  }

  @Override
  public String toString() {
    return "Label{" +
        "labelName='" + labelName + '\'' +
        '}';
  }
}
