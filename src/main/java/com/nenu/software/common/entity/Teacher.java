package com.nenu.software.common.entity;

import javax.persistence.Entity;

@Entity
public class Teacher {

  private long id;
  private String teaName;
  private String teaNum;
  private String password;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getTeaName() {
    return teaName;
  }

  public void setTeaName(String teaName) {
    this.teaName = teaName;
  }


  public String getTeaNum() {
    return teaNum;
  }

  public void setTeaNum(String teaNum) {
    this.teaNum = teaNum;
  }


  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

}
