
package com.example.student;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins="http://localhost:3000")
@RequestMapping("/students")
public class StudentController{

 @Autowired
 private StudentService service;

 @PostMapping
 public ResponseEntity<Student> addStudent(@RequestBody Student s){
  return ResponseEntity.ok(service.addStudent(s));
 }

 @GetMapping
 public ResponseEntity<List<Student>> getStudents(){
  return ResponseEntity.ok(service.getAllStudents());
 }

 @PutMapping("/{id}")
 public ResponseEntity<Student> updateStudent(@PathVariable Long id,@RequestBody Student s){
  return ResponseEntity.ok(service.updateStudent(id,s));
 }

 @DeleteMapping("/{id}")
 public ResponseEntity<?> deleteStudent(@PathVariable Long id){
  service.deleteStudent(id);
  return ResponseEntity.ok().build();
 }
}
