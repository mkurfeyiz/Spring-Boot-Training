package com.mk.service;

import com.mk.model.Brand;
import com.mk.model.Category;
import com.mk.model.Product;
import com.mk.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService implements IProductService{
    private final ProductRepository productRepository;

    public List<Product> getProducts(){
        return productRepository.findAll();
    }

    @Transactional
    public void addProduct(){
        Product product = new Product();
        Brand brand = new Brand();
        brand.setBrandName("Apple");
        Category category = new Category();
        category.setCategoryName("pc");

        product.setProductName("macbook air 2017");
        product.setPrice(new BigDecimal("11.000"));
        //product.setBrand(brand);
        //product.setCategory(category);

        productRepository.save(product);

    }

    @Transactional
    public void updateProduct(Long id){
        Optional<Product> optionalProduct = productRepository.findById(id);
        if(optionalProduct.isPresent()){
            Product product = optionalProduct.get();
            product.setProductName("tişört");
            productRepository.save(product);
        } else {
            addProduct();
        }
    }

    @Transactional
    public void deleteProduct(Long id){
        Optional<Product> optionalProduct = productRepository.findById(id);
        if(optionalProduct.isPresent()){
            productRepository.deleteById(optionalProduct.get().getId());
        }
    }
}
