package com.nenu.software.common.dto;

/**
 * @author shanjz
 * @since 2018/6/23 13:12
 */
public class ElectiveDto {

    private long id;
    private long stuId;
    private String stuName;
    private long courseId;
    private String courseName;
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

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getStuName() {
        return stuName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseName() {
        return courseName;
    }
}
