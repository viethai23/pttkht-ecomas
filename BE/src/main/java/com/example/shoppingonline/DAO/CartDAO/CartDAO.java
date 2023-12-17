package com.example.shoppingonline.DAO.CartDAO;

import com.example.shoppingonline.Model.Order.Cart;
import com.example.shoppingonline.Model.Order.Item;
import com.example.shoppingonline.Model.Order.Order;
import com.example.shoppingonline.Model.User.Customer;

public interface CartDAO {

	Cart clearCart(int cartId);

	Cart addCartItem(int cartId, Item i);

	Cart removeCartItem(int cartId, int itemId);

	Cart getCustomerCart(int cusId);

	Cart updateQuantity(int cartId, int itemId, int quantity);

	Cart createCart(int cusId);
}