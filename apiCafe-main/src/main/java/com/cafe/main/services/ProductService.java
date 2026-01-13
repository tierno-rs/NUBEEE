package com.cafe.main.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe.main.models.ProductModel;
import com.cafe.main.repositories.ProductRepository;

@Service
public class ProductService {
    
    @Autowired
    private ProductRepository productRepository;

    public List<ProductModel> getProducts(){
        return productRepository.findAll();
    }
    public ProductModel getProductById(int id){
        return productRepository.findById(id).orElse(null);
    }
    public ProductModel createProduct(ProductModel product){
        return productRepository.save(product);
    }
    public ProductModel updateProduct(int id, ProductModel product){
        ProductModel existingProduct = productRepository.findById(id).orElse(null);
        if(existingProduct != null){
            existingProduct.setName(product.getName());
            existingProduct.setDescription(product.getDescription());
            existingProduct.setPrice(product.getPrice());
            existingProduct.setCategory(product.getCategory());
            return productRepository.save(existingProduct);
        }
        return null;
    }
    public void deleteProduct(int id){
        productRepository.deleteById(id);
    }

    public long totalProducts(){
        return productRepository.count();
    }

   

}
