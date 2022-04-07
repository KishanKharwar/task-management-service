package com.jaza.software.tms.models;

import java.util.Arrays;

public enum Priority {
  CRITICAL("critical"),HIGH("high"),MEDIUM("medium"),LOW("low");

  private String value;
  private Priority(String value){
    this.value = value;
  }

  public static Priority fromValue(String value) {
    for (Priority priority : values()) {
      if (priority.value.equalsIgnoreCase(value)) {
        return priority;
      }
    }
    throw new IllegalArgumentException(
        "Unknown enum type " + value + ", Allowed values are " + Arrays.toString(values()));
  }


}
