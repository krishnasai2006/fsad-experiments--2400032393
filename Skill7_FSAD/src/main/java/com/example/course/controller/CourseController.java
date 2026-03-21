
package com.example.course.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import com.example.course.model.Course;
import com.example.course.service.CourseService;

@RestController
@RequestMapping("/courses")
public class CourseController {

 @Autowired
 private CourseService service;

 @PostMapping
 public ResponseEntity<Course> add(@RequestBody Course c){
  return new ResponseEntity<>(service.addCourse(c), HttpStatus.CREATED);
 }

 @GetMapping
 public ResponseEntity<List<Course>> get(){
  return ResponseEntity.ok(service.getAll());
 }

 @PutMapping("/{id}")
 public ResponseEntity<String> update(@PathVariable int id,@RequestBody Course c){
  service.update(id,c);
  return ResponseEntity.ok("Updated Successfully");
 }

 @DeleteMapping("/{id}")
 public ResponseEntity<String> delete(@PathVariable int id){
  service.delete(id);
  return ResponseEntity.ok("Deleted Successfully");
 }

 @GetMapping("/search/{title}")
 public ResponseEntity<List<Course>> search(@PathVariable String title){
  return ResponseEntity.ok(service.search(title));
 }
}
