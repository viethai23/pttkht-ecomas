package com.example.shoppingonline.Controller;

import com.example.shoppingonline.DAO.ShippingDAO.ShippingDAO;
import com.example.shoppingonline.DTO.ShippingResponse;
import com.example.shoppingonline.Model.Order.Order;
import com.example.shoppingonline.Model.Order.Shipping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/shipping")
@CrossOrigin
public class ShippingController {

    private final ShippingDAO shippingDAO;

    @Autowired
    public ShippingController(ShippingDAO shippingDAO) {
        this.shippingDAO = shippingDAO;
    }

    @PostMapping("/calculateCost")
    public ShippingResponse calculateCost(@RequestBody Shipping shipping) {
        return shippingDAO.calculateCost(shipping);
    }

}
