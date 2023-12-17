package com.example.shoppingonline.DAO.ShippingDAO;

import com.example.shoppingonline.DTO.ShippingResponse;
import com.example.shoppingonline.Model.Order.Order;
import com.example.shoppingonline.Model.Order.Shipping;

public interface ShippingDAO {

	ShippingResponse calculateCost(Shipping s);
}