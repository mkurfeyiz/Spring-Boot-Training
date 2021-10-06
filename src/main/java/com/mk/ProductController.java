package com.mk;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("products")
public class ProductController {

    List<String> products;

    public ProductController(List<String> products){
        this.products = products;
    }

    @GetMapping("getProducts")
    public List<String> getProducts(){
        return products;
    }

    @GetMapping("getProductByIndex")
    public String getProductByIndex(@RequestParam int index){
        return products.get(index);
    }

    @GetMapping("getProductByName")
    public String getProductByName(@RequestParam String product){
        int index = products.indexOf(product);
        return products.get(index);
    }

    @PostMapping("addProduct")
    public void addProduct(@RequestBody String product){
        products.add(product);
    }

    //This makes path variables to be optional
    //@PutMapping(value = {"updateProduct", "updateProduct/{index}/{product}"})
    @PutMapping("updateProduct/{index}/{product}")
    public void updateProduct(@PathVariable("index") int index, @PathVariable("product") String product){
        products.set(index, product);
    }

    @DeleteMapping(value = {"deleteProduct", "deleteProduct/{index}"})
    public void deleteProduct(@PathVariable(required = false) int index){
        products.remove(index-1);
    }
}