package com.cafe.main.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cafe.main.models.ProductModel;
import com.cafe.main.services.ProductService;

@CrossOrigin
@RestController
@RequestMapping(path = "/product")
public class ProductController {
    
    @Autowired
    private ProductService productService;

    @GetMapping("/getAll")
    public List<ProductModel> getAll(){
        return productService.getProducts();
    }

    @GetMapping("/getOne/{id}")
    public ProductModel getProduct(@PathVariable int id){
        return productService.getProductById(id);
    }

    @PostMapping("/save")
    public ProductModel save(@RequestBody ProductModel productModel) {
        return productService.createProduct(productModel);
    }

    @PutMapping("/update/{id}")
    public ProductModel update(@PathVariable int id, @RequestBody ProductModel productModel) {
        return productService.updateProduct(id, productModel);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable int id) {
        productService.deleteProduct(id);
    }

    @GetMapping("/totalProducts")
    public long totalProducts(){
        return productService.totalProducts();
    }


}
