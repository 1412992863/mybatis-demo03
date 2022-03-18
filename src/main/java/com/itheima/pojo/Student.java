package com.itheima.pojo;

public class Student {
    Integer id;
    String name;
    String major;
    Integer sno;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public Integer getSno() {
        return sno;
    }

    public void setSno(Integer sno) {
        this.sno = sno;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", major='" + major + '\'' +
                ", sno=" + sno +
                '}';
    }

    public Student(Integer id, String name, String major, Integer sno) {
        this.id = id;
        this.name = name;
        this.major = major;
        this.sno = sno;
    }

    public Student(String name, String major, Integer sno) {
        this.name = name;
        this.major = major;
        this.sno = sno;
    }

    public Student() {
    }
}
