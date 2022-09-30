package com.kazi.store.controller;

import com.kazi.store.model.Admin;
import com.kazi.store.model.Orders;
import com.kazi.store.model.Products;
import com.kazi.store.model.User;
import com.kazi.store.repo.AdminRepo;
import com.kazi.store.repo.OrdersRepo;
import com.kazi.store.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("http://localhost:4200/")
@RestController
public class AdminController {
    @Autowired
    private AdminRepo aRepo;

    @Autowired
    private OrdersRepo oRepo;

    @GetMapping("/admin/find/all")
    public List<Admin> getAllProduct(){
        return aRepo.findAll();
    }

    @PostMapping("/admin/add")
    public String addProduct(@RequestBody Admin ad){
        aRepo.save(ad);
        return "Added product with id "+ad.getUserName();
    }

    @PostMapping("/admin/delete")
    public void deleteProduct(@RequestBody String userName){
        aRepo.deleteById(userName);

    }

    @GetMapping("/admin/find/{userName}")
    public Optional<Admin> getUserByUserName(@PathVariable String userName){
        return aRepo.findById(userName);
    }

}
