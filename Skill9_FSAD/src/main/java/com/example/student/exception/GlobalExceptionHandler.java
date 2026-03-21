
package com.example.student.exception;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.*;
import java.time.*;
import java.util.*;

@ControllerAdvice
public class GlobalExceptionHandler {

 @ExceptionHandler(StudentNotFoundException.class)
 public ResponseEntity<Map<String,Object>> handleNotFound(StudentNotFoundException ex){
  Map<String,Object> map=new HashMap<>();
  map.put("timestamp", LocalDateTime.now());
  map.put("message", ex.getMessage());
  map.put("status",404);
  return new ResponseEntity<>(map,HttpStatus.NOT_FOUND);
 }

 @ExceptionHandler(InvalidInputException.class)
 public ResponseEntity<Map<String,Object>> handleInvalid(InvalidInputException ex){
  Map<String,Object> map=new HashMap<>();
  map.put("timestamp", LocalDateTime.now());
  map.put("message", ex.getMessage());
  map.put("status",400);
  return new ResponseEntity<>(map,HttpStatus.BAD_REQUEST);
 }
}
