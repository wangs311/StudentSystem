package com.nenu.software.common.entity;

import javax.persistence.Entity;

@Entity
public class Elective {

  private long id;
  private long stuId;
  private long courseId;
  private double score;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public long getStuId() {
    return stuId;
  }

  public void setStuId(long stuId) {
    this.stuId = stuId;
  }


  public long getCourseId() {
    return courseId;
  }

  public void setCourseId(long courseId) {
    this.courseId = courseId;
  }


  public double getScore() {
    return score;
  }

  public void setScore(double score) {
    this.score = score;
  }

}
