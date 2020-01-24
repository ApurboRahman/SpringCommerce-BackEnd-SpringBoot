package com.eas.emp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "gender")
public class GenderModel implements Serializable {
  @Id
  @Column(name = "id")
  private char id;

  @Column(name = "name")
  private String name;

  public char getId() {
    return id;
  }

  public void setId(char id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
