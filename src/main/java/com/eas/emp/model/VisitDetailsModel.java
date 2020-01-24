package com.eas.emp.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "visitdetails")
public class VisitDetailsModel {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long id;

  @Column(name = "employee_id")
  private String employeeId;

  @Column(name = "goouttime")
  private Timestamp goOutTime;

  @Column(name = "returntime")
  private Timestamp returnTime;

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
}
