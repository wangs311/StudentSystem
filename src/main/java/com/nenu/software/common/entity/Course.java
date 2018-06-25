package com.nenu.software.common.entity;

import javax.persistence.Entity;

@Entity
public class Course {

  private long id;
  private String courseName;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getCourseName() {
    return courseName;
  }

  public void setCourseName(String courseName) {
    this.courseName = courseName;
  }

}
