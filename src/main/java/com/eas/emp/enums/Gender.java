package com.eas.emp.enums;

public enum Gender {
  MALE('M'),
  FEMALE('F');

  private final char value;

  Gender(char value) {
    this.value = value;
  }

  public char value() {
    return value;
  }
}
