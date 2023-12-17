package com.example.shoppingonline.DAO.CartDAO;

import com.example.shoppingonline.Model.Order.Cart;
import com.example.shoppingonline.Model.Order.Item;

import com.example.shoppingonline.Model.Product.Product;
import com.example.shoppingonline.Model.User.Customer;
import com.example.shoppingonline.Repository.CartRepository;
import com.example.shoppingonline.Repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartDAOImpl implements CartDAO {

	@Autowired
	private CartRepository cartRepository;

	@Autowired
	private ItemRepository itemRepository;

	@Override
	public Cart clearCart(int cartId) {
		Cart cart = getCartById(cartId);
		if (cart != null) {
			cart.getItems().clear();
			cart.setTotal(0);
			cart.setTotalItem(0);
			cartRepository.save(cart);
			return cart;
		}
		return null;
	}

	@Override
	public Cart addCartItem(int cartId, Item item) {
		Cart cart = cartRepository.findById(cartId).orElse(null);
		Item itemExist = itemRepository.findByProduct_IdAndCart_Id(item.getProduct().getId(), cartId);

		if (cart != null && itemExist == null) {
			Product product = item.getProduct();
			int quantity = item.getQuantity();
			if(quantity > product.getStockQuantity() || quantity < 0) {
				return null;
			}
			double itemAmount = product.getPrice() * quantity;

			item.setCart(cart);
			item.setAmount(itemAmount);

			cart.getItems().add(item);
			cart.setTotalItem(cart.getTotalItem() + 1);
			cart.setTotal(cart.getTotal() + itemAmount);
			return cartRepository.save(cart);
		}
		else {
			return null;
		}

	}

	@Override
	public Cart removeCartItem(int cartId, int itemId) {
		Cart cart = cartRepository.findById(cartId).orElse(null);

		if (cart != null) {
			Item itemToRemove = cart.getItems().stream()
					.filter(item -> item.getId() == itemId)
					.findFirst()
					.orElse(null);

			if (itemToRemove != null) {
				double itemAmount = itemToRemove.getAmount();

				cart.getItems().remove(itemToRemove);
				cart.setTotalItem(cart.getTotalItem() - 1);
				cart.setTotal(cart.getTotal() - itemAmount);
				cartRepository.save(cart);
			}
		}
		return cart;

	}

	@Override
	public Cart getCustomerCart(int cusId) {
		Cart cart = cartRepository.findByCustomer_IdAndStatus(cusId, "present");
		if(cart == null) {
			cart = createCart(cusId);
		}
		return cart;
	}

	@Override
	public Cart updateQuantity(int cartId, int itemId, int quantity) {
		Cart cart = cartRepository.findById(cartId).orElse(null);

		if (cart != null) {
			Item itemToUpdate = cart.getItems().stream()
					.filter(item -> item.getId() == itemId)
					.findFirst()
					.orElse(null);

			if (itemToUpdate != null) {
				double originalItemAmount = itemToUpdate.getAmount();

				if(quantity > itemToUpdate.getProduct().getStockQuantity() || quantity < 0) {
					return null;
				}

				itemToUpdate.setQuantity(quantity);
				itemToUpdate.setAmount(itemToUpdate.getProduct().getPrice() * quantity);

				double newItemAmount = itemToUpdate.getAmount();
				cart.setTotal(cart.getTotal() - originalItemAmount + newItemAmount);

				cartRepository.save(cart);
			}
		}

		return cart;
	}

	@Override
	public Cart createCart(int cusId) {
		Customer customer = new Customer();
		customer.setId(cusId);

		Cart cart = new Cart();
		cart.setCustomer(customer);
		cart.setStatus("present");

		return cartRepository.save(cart);
	}

	private Cart getCartById(int id) {
		return cartRepository.findById(id).orElse(null);
	}
}