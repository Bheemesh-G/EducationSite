package com.FirstProject.EducationSite;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public String addStudent(Student student)
    {
        return studentRepository.addStudent(student);
    }

    public Student getStudent(int id)
    {
        return studentRepository.getStudent(id);
    }

    public String addCourse(Course course){
        return studentRepository.addCourse(course);
    }

    public Course getCourse(String name){
        return studentRepository.getCourse(name);
    }
    public String addStudentCourse(String studentName,String courseName){

        return studentRepository.addStudentCourse(studentName,courseName);
    }
    public List<String> listOfCoursesStudentEnrolled(String name){
        return studentRepository.listOfCoursesStudentEnrolled(name);
    }
    public List<String> listStudentsEnrolledInACourse(String name){
        return studentRepository.listStudentsEnrolledInACourse(name);
    }
}
