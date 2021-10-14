package com.mk.service;

import com.mk.model.Product;

import java.util.List;

public interface IProductService {
    public List<Product> getProducts();
    public void addProduct();
    public void updateProduct(Long id);
    public void deleteProduct(Long id);
}
