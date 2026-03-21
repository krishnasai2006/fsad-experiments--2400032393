
package com.example;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
public class LibraryController {

 List<String> books = new ArrayList<>(Arrays.asList(
  "Java Programming","Spring Boot Guide","Data Structures"
 ));

 @GetMapping("/welcome")
 public String welcome(){
  return "<h1>Welcome to Online Library System</h1>";
 }

 @GetMapping("/count")
 public int count(){
  return books.size();
 }

 @GetMapping("/price")
 public double price(){
  return 499.99;
 }

 @GetMapping("/books")
 public List<String> getBooks(){
  return books;
 }

 @GetMapping("/books/{id}")
 public String getBook(@PathVariable int id){
  return "Book details for ID: " + id;
 }

 @GetMapping("/search")
 public String search(@RequestParam String title){
  return "Searching for book: " + title;
 }

 @GetMapping("/author/{name}")
 public String author(@PathVariable String name){
  return "Books by author: " + name;
 }

 @PostMapping("/addbook")
 public String addBook(@RequestBody Map<String,String> book){
  books.add(book.get("title"));
  return "Book added successfully";
 }

 @GetMapping("/viewbooks")
 public List<String> viewBooks(){
  return books;
 }
}
