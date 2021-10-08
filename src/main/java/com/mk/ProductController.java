package com.mk;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("product")
public class ProductController {

    List<String> products;

    public ProductController(List<String> products) {
        this.products = products;
        this.products.add("tablet");
        this.products.add("telefon");
        this.products.add("bilgisayar");
    }

    @GetMapping("products")
    public List<String> getProducts() {
        return products;
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
    public void addProduct(@RequestBody String product) {
        products.add(product);
    }

    //This makes path variables to be optional
    //@PutMapping(value = {"updateProduct", "updateProduct/{index}/{product}"})
    @PutMapping("products/{index}/{product}")
    public void updateProduct(@PathVariable("index") int index, @PathVariable("product") String product) {
        products.set(index, product);
    }

    @DeleteMapping(value = {"products", "products/{index}"})
    public void deleteProduct(@PathVariable(required = false) int index) {
        products.remove(index - 1);
    }
}