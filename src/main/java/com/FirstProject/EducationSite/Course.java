package com.FirstProject.EducationSite;

public class Course {
    private String name;
    private String teacherName;

    private int fee;

    public Course(String name, String teacherName, int fee) {
        this.name = name;
        this.teacherName = teacherName;
        this.fee = fee;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public int getFee() {
        return fee;
    }

    public void setFee(int fee) {
        this.fee = fee;
    }
}
