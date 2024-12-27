package com.mkahn.mkahn.constant;

public class EnumType {
  public enum UserStatus {
    NORMAL("정상"),REQUEST("신청"),DELETE("탈퇴");

    private final String name;

    UserStatus(String name) {
      this.name = name;
    }

    public String getName() {
      return name;
    }
  }

  public enum AlertState {
    INFO,MINOR,MAJOR,CRITICAL,CLEAR
  }
  public AlertState getAlertStatue(String param) {
    if(AlertState.INFO.toString().equals(param)) {
      return AlertState.INFO;
    }else if(AlertState.MINOR.toString().equals(param)) {
      return AlertState.MINOR;
    }else if(AlertState.MAJOR.toString().equals(param)) {
      return AlertState.MAJOR;
    }else if(AlertState.CRITICAL.toString().equals(param)) {
      return AlertState.CRITICAL;
    }
    return AlertState.CRITICAL;
  }
}
