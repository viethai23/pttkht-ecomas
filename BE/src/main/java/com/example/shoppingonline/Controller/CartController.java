package com.example.shoppingonline.Controller;

import com.example.shoppingonline.DAO.CartDAO.CartDAO;
import com.example.shoppingonline.Model.Order.Cart;
import com.example.shoppingonline.Model.Order.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cart")
@CrossOrigin
public class CartController {

    @Autowired
    private CartDAO cartDAO;

    @PostMapping("/clear/{cartId}")
    public Cart clearCart(@PathVariable int cartId) {
        return cartDAO.clearCart(cartId);
    }

    @PostMapping("/add/{cartId}")
    public ResponseEntity<Cart> addCartItem(@PathVariable int cartId, @RequestBody Item item) {
        Cart cart = cartDAO.addCartItem(cartId, item);
        if (cart != null) {
            return ResponseEntity.ok(cart);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PostMapping("/remove/{cartId}/{itemId}")
    public ResponseEntity<Cart> removeCartItem(@PathVariable int cartId, @PathVariable int itemId) {
        Cart cart = cartDAO.removeCartItem(cartId, itemId);
        if (cart != null) {
            return ResponseEntity.ok(cart);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @GetMapping("/get/{cusId}")
    public Cart getCustomerCart(@PathVariable int cusId) {
        return cartDAO.getCustomerCart(cusId);
    }

    @PostMapping("/updateQuantity/{cartId}/{itemId}/{quantity}")
    public Cart updateQuantity(
            @PathVariable int cartId,
            @PathVariable int itemId,
            @PathVariable int quantity
    ) {
        return cartDAO.updateQuantity(cartId, itemId, quantity);
    }

    @GetMapping("/createCart/{customerId}")
    public Cart createCart(@PathVariable int customerId) {
        return cartDAO.createCart(customerId);
    }
}
