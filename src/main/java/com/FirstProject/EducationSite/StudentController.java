package com.FirstProject.EducationSite;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    StudentService studentService;


    @PostMapping("/add-student")
    public ResponseEntity addStudent(@RequestBody() Student student)
    {
        String responce = studentService.addStudent(student);
        return new ResponseEntity<>(responce, HttpStatus.CREATED);
    }

    @GetMapping("/get-student")
    public ResponseEntity getStudent(@RequestParam("id") int id)
    {
        Student student = studentService.getStudent(id);

        return new ResponseEntity<>(student,HttpStatus.FOUND);
    }

    @PostMapping("/add-course")
    public ResponseEntity addCourse(@RequestBody() Course course)
    {
       String response = studentService.addCourse(course);

        return new ResponseEntity<>(response,HttpStatus.CREATED);

    }



    @GetMapping("/get-course/{name}")
    public ResponseEntity getCourse(@PathVariable String name){
        Course c= studentService.getCourse(name);

        return new ResponseEntity<>(c,HttpStatus.FOUND);
    }


    @PutMapping("/add-student-course")
    public ResponseEntity addStudentCourse(@RequestParam String studentName,@RequestParam String courseName)
    {
        String responce = studentService.addStudentCourse(studentName,courseName);

        return new ResponseEntity<>(responce,HttpStatus.CREATED);
    }


    @GetMapping("/list-of-courses-student-enrolled/{name}")
    public ResponseEntity listOfCoursesStudentEnrolled(@PathVariable String name){
        List<String> list = studentService.listOfCoursesStudentEnrolled(name);

        return new ResponseEntity<>(list,HttpStatus.FOUND);
    }


    @GetMapping("/list-of-students-enrolled-in-course/{name}")
    public ResponseEntity listStudentsEnrolledInACourse(@PathVariable String name){
        List<String> list = studentService.listStudentsEnrolledInACourse(name);

        return new ResponseEntity<>(list,HttpStatus.FOUND);
    }
}
