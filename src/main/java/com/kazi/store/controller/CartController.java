package com.kazi.store.controller;

import com.kazi.store.model.Cart;
import com.kazi.store.repo.CartRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:4200/")
@RestController
public class CartController {
    @Autowired
    private CartRepo cRepo;


    @GetMapping("/cart/product/find/all")
    public List<Cart> getAllCartProduct(){
        return cRepo.findAll();
    }

    @PostMapping("/cart/product/add")
    public String addCartProduct(@RequestBody Cart prc){
        cRepo.save(prc);
        return "Added product to cart with id "+prc.getProductId();
    }

    @PostMapping("/cart/product/delete")
    public void deleteCartProduct(@RequestBody int id){
        cRepo.deleteById(id);

    }
}
