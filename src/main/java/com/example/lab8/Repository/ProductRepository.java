package com.example.lab8.Repository;

import com.example.lab8.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product,Integer> {
    public long countById(Integer id);

    @Query("select product from Product product where product.id= ?1")
    Product getProductsById(int id);
}
