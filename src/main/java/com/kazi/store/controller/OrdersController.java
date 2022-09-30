package com.kazi.store.controller;

import com.kazi.store.model.Cart;
import com.kazi.store.model.Orders;
import com.kazi.store.repo.OrdersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:4200/")
@RestController
public class OrdersController {
    @Autowired
    private OrdersRepo oRepo;

    @GetMapping("/orders/find/all")
    public List<Orders> getAllOrders(){
        return oRepo.findAll();
    }

    @PostMapping("/orders/add")
    public String addOrders(@RequestBody Orders odr){
        oRepo.save(odr);
        return "Added product to cart with id "+odr.getId();
    }

    @PostMapping("/orders/delete")
    public void deleteOrdersById(@RequestBody int id){
        oRepo.deleteById(id);

    }

    @GetMapping("/orders/tota")
    public int totalCart(){
        List<Orders> odr = oRepo.findAll();
        return odr.size();
    }

    @GetMapping("/orders/newOrderId")
    public int newOrderId(){
        List<Orders> odr = oRepo.findAll();
        int newId = ((odr.get(odr.size()-1).getId())+1);
        return newId;
    }
}
