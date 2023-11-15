package com.example.lab8.Repository;

import com.example.lab8.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired private ProductRepository productRepository;

    public List<Product> listAllProducts()
    {
        return (List<Product>) productRepository.findAll();
    }

    public void deleteProduct(Integer id)
    {
        Long count = productRepository.countById(id);
        if(count==null || count == 0 )
        {
            throw new UsernameNotFoundException("");
        }
        productRepository.deleteById(id);
    }

    public void saveProduct(Product product)
    {
        productRepository.save(product);
    }
    public void updateProduct(Product product)
    {
        Product item = productRepository.getProductsById(product.getId());
        item.setName(product.getName());
        item.setPrice(product.getPrice());
        item.setDescription(product.getDescription());
    }
}
