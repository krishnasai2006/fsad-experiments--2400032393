
package com.example;

import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

 @GetMapping("/hello")
 public String hello(){
  return "Backend API Working Successfully";
 }
}
