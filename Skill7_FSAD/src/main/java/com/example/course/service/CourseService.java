
package com.example.course.service;

import org.springframework.stereotype.Service;
import java.util.*;
import com.example.course.model.Course;

@Service
public class CourseService {

 private List<Course> list = new ArrayList<>();

 public Course addCourse(Course c){
  list.add(c);
  return c;
 }

 public List<Course> getAll(){
  return list;
 }

 public Course update(int id, Course c){
  return c;
 }

 public String delete(int id){
  return "Deleted";
 }

 public List<Course> search(String title){
  return list;
 }
}
