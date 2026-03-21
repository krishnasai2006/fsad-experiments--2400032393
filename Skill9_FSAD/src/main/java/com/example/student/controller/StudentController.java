
package com.example.student.controller;

import org.springframework.web.bind.annotation.*;
import java.util.*;
import com.example.student.model.Student;
import com.example.student.exception.*;

@RestController
public class StudentController {

 List<Student> list = new ArrayList<>();

 public StudentController(){
  Student s=new Student();
  s.setId(1);
  s.setName("Ganesh");
  s.setCourse("CSE");
  list.add(s);
 }

 @GetMapping("/student/{id}")
 public Student getStudent(@PathVariable int id){
  if(id<=0) throw new InvalidInputException("Invalid ID format");
  return list.stream()
   .filter(s->s.getId()==id)
   .findFirst()
   .orElseThrow(()->new StudentNotFoundException("Student not found"));
 }
}
