
package com.example.library.controller;

import org.springframework.web.bind.annotation.*;
import java.util.*;
import com.example.library.model.Book;

@RestController
public class LibraryController {

 List<Book> bookList = new ArrayList<>();

 @GetMapping("/welcome")
 public String welcome(){
  return "<h1>Welcome to Online Library System</h1>";
 }

 @GetMapping("/count")
 public int count(){
  return bookList.size();
 }

 @GetMapping("/price")
 public double price(){
  return 499.99;
 }

 @GetMapping("/books")
 public List<String> books(){
  return Arrays.asList("Java Programming","Spring Boot Guide","Data Structures");
 }

 @GetMapping("/books/{id}")
 public String bookById(@PathVariable int id){
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
 public String addBook(@RequestBody Book book){
  bookList.add(book);
  return "Book added successfully";
 }

 @GetMapping("/viewbooks")
 public List<Book> viewBooks(){
  return bookList;
 }
}
