package com.eas.emp.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "dailyattendance")
public class DailyAttendanceModel {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long id;

  @Column(name = "employeeId")
  private String employeeId;

  @Column(name = "date")
  @Temporal(value = TemporalType.DATE)
  private Date date;

  @Transient private String dayName;

  @Column(name = "intime")
  private Timestamp inTime;

  @Column(name = "outtime")
  private Timestamp outTime;

  @Column(name = "goouttime")
  private Timestamp goOutTime;

  @Column(name = "returntime")
  private Timestamp returnTime;

  @Transient private String totalWorkingTime;
  @Transient private String extraWork;
  @Transient private String underWork;
  @Transient private String late;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getEmployeeId() {
    return employeeId;
  }

  public void setEmployeeId(String employeeId) {
    this.employeeId = employeeId;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public String getDayName() {
    return dayName;
  }

  public void setDayName(String dayName) {
    this.dayName = dayName;
  }

  public Timestamp getInTime() {
    return inTime;
  }

  public void setInTime(Timestamp inTime) {
    this.inTime = inTime;
  }

  public Timestamp getOutTime() {
    return outTime;
  }

  public void setOutTime(Timestamp outTime) {
    this.outTime = outTime;
  }

  public Timestamp getGoOutTime() {
    return goOutTime;
  }

  public void setGoOutTime(Timestamp goOutTime) {
    this.goOutTime = goOutTime;
  }

  public Timestamp getReturnTime() {
    return returnTime;
  }

  public void setReturnTime(Timestamp returnTime) {
    this.returnTime = returnTime;
  }

  public String getTotalWorkingTime() {
    return totalWorkingTime;
  }

  public void setTotalWorkingTime(String totalWorkingTime) {
    this.totalWorkingTime = totalWorkingTime;
  }

  public String getExtraWork() {
    return extraWork;
  }

  public void setExtraWork(String extraWork) {
    this.extraWork = extraWork;
  }

  public String getUnderWork() {
    return underWork;
  }

  public void setUnderWork(String underWork) {
    this.underWork = underWork;
  }

  public String getLate() {
    return late;
  }

  public void setLate(String late) {
    this.late = late;
  }
}
