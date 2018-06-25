package com.nenu.software.common.entity;

import javax.persistence.Entity;

@Entity
public class Class {

  private long id;
  private String grade;
  private String className;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getGrade() {
    return grade;
  }

  public void setGrade(String grade) {
    this.grade = grade;
  }


  public String getClassName() {
    return className;
  }

  public void setClassName(String className) {
    this.className = className;
  }

}
