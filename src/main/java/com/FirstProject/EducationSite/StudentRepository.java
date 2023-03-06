package com.FirstProject.EducationSite;


import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class StudentRepository {

     HashMap<Integer,Student>  studentMap= new HashMap<>();
    HashMap<String,Course> courseMap = new HashMap<>();
    HashMap<String, List<String>> studentCourseMap = new HashMap<>();
    HashMap<String,List<String>> courseStudentMap = new HashMap<>();

    public String addStudent(Student student)
    {
        studentMap.put(student.getId(),student);

        return "Student added Successfully";
    }

    public Student getStudent(int id)
    {
        return studentMap.get(id);
    }

    public String addCourse(Course course)
    {
        courseMap.put(course.getName(),course);
        return "Course added Successfully";
    }

    public Course getCourse(String name)
    {
        return courseMap.get(name);
    }

    public void addSCourse(String studentName,String courseName)
    {
        if(studentCourseMap.containsKey(studentName))
        {
            List<String> list = studentCourseMap.get(studentName);
            list.add(courseName);
            studentCourseMap.put(studentName,list);
        }
        else{
            List<String> list = new ArrayList<>();
            list.add(courseName);
            studentCourseMap.put(studentName,list);
        }
    }

    public void addCStudent(String studentName,String courseName)
    {
        if(courseStudentMap.containsKey(courseName))
        {
            List<String> list = courseStudentMap.get(courseName);
            list.add(studentName);
            courseStudentMap.put(courseName,list);
        }
        else{
            List<String> list = new ArrayList<>();
            list.add(studentName);
            courseStudentMap.put(courseName,list);
        }
    }

    public int find(String name)
    {
        for(int i:studentMap.keySet())
        {
            if(studentMap.get(i).getName().equals(name))
            {
                return i;
            }
        }

        return 0;
    }
    public String addStudentCourse(String studentName,String courseName)
    {
        int rollNumber = find(studentName);
        if( rollNumber!=0 && studentMap.containsKey(rollNumber) && courseMap.containsKey(courseName))
        {
            addSCourse(studentName,courseName);
            addCStudent(studentName,courseName);

            return "Student and Course added Successfully";
        }

        return "Student or Course is not present";
    }

    public List<String> listOfCoursesStudentEnrolled(String name)
    {
        return studentCourseMap.get(name);
    }

    public List<String> listStudentsEnrolledInACourse(String name)
    {
        return courseStudentMap.get(name);
    }
}
