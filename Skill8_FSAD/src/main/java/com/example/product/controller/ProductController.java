
package com.example.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import com.example.product.model.Product;
import com.example.product.repository.ProductRepository;

@RestController
@RequestMapping("/products")
public class ProductController {

 @Autowired
 private ProductRepository repo;

 @GetMapping("/category/{category}")
 public List<Product> byCategory(@PathVariable String category){
  return repo.findByCategory(category);
 }

 @GetMapping("/filter")
 public List<Product> filter(@RequestParam double min,@RequestParam double max){
  return repo.findByPriceBetween(min,max);
 }

 @GetMapping("/sorted")
 public List<Product> sorted(){
  return repo.findAllSorted();
 }

 @GetMapping("/expensive/{price}")
 public List<Product> expensive(@PathVariable double price){
  return repo.findExpensive(price);
 }

 @GetMapping
 public List<Product> all(){
  return repo.findAll();
 }
}
