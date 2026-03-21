
package com.example.product.repository;

import org.springframework.data.jpa.repository.*;
import java.util.*;
import com.example.product.model.Product;

public interface ProductRepository extends JpaRepository<Product,Long>{

 List<Product> findByCategory(String category);

 List<Product> findByPriceBetween(double min,double max);

 @Query("SELECT p FROM Product p ORDER BY p.price ASC")
 List<Product> findAllSorted();

 @Query("SELECT p FROM Product p WHERE p.price > :price")
 List<Product> findExpensive(double price);
}
