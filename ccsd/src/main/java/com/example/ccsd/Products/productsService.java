package com.example.ccsd.Products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class productsService {

    @Autowired
    private productsRepository ProductsRepository;

    public List<products> getAllProducts() {
        return ProductsRepository.findAll();
    }

    public Optional<products> getProductsById(String id) {
        return ProductsRepository.findById(id);
    }

    public products addProducts(products product) {
        return ProductsRepository.save(product);
    }



}