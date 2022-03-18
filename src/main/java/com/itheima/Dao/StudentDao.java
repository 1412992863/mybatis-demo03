package com.itheima.Dao;

import com.itheima.pojo.Student;

import java.util.List;

public interface StudentDao {
    /**
     * 多值查询
     *
     * @param student 用户输入参数，Student封装
     * @return StudentList
     */
    List<Student> getStudents(Student student);

    /**
     * 单条件查询，查询ID小于用户输入ID的学生
     *
     * @param id 用户输入参数，
     * @return StudentList
     */
    List<Student> getStudent(Integer id);
}
