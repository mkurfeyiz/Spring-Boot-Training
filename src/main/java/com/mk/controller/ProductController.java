package com.mk;

import com.mk.model.Product;
import com.mk.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("product")
public class ProductController {

    @Autowired
    private IProductService productService;
    List<String> products;

    public ProductController(List<String> products) {
        this.products = products;
        this.products.add("tablet");
        this.products.add("telefon");
        this.products.add("bilgisayar");
    }

    @GetMapping("products")
    public List<Product> getProducts() {
        return productService.getProducts();
    }

    @GetMapping("products-by-index")
    public String getProductByIndex(@RequestParam int index) {
        return products.get(index);
    }

    @GetMapping("products-by-name")
    public String getProductByName(@RequestParam String product) {
        int index = products.indexOf(product);
        return products.get(index);
    }

    @PostMapping("products")
    public void addProduct(@RequestBody Product product) {
        //products.add(product);
        productService.addProduct();
    }

    //This makes path variables to be optional
    //@PutMapping(value = {"updateProduct", "updateProduct/{index}/{product}"})
    @PutMapping("products/{index}/{product}")
    public void updateProduct(@PathVariable("index") String index, @PathVariable("product") String product) {
        //products.set(index, product);
        productService.updateProduct(Long.parseLong(index));
    }

    @DeleteMapping(value = {"products", "products/{index}"})
    public void deleteProduct(@PathVariable(required = false) String index) {
        //products.remove(index - 1);
        productService.deleteProduct(Long.parseLong(index));
    }
}