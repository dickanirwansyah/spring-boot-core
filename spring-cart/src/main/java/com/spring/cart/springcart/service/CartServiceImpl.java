package com.spring.cart.springcart.service;

import com.spring.cart.springcart.entity.CartItem;
import com.spring.cart.springcart.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.spring.cart.springcart.entity.Cart;
import com.spring.cart.springcart.repository.CartRepository;
import com.spring.cart.springcart.repository.ProductRepository;
import com.spring.cart.springcart.request.AddProductToCartRequest;
import com.spring.cart.springcart.request.CreateCartRequest;
import com.spring.cart.springcart.request.DeleteProductInCartRequest;
import com.spring.cart.springcart.request.GetCartDetailRequest;
import com.spring.cart.springcart.request.UpdateProductInCartRequest;

import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;

@Service
@Transactional
@Repository
public class CartServiceImpl implements CartService{

	@Autowired
	private CartRepository cartrepo;
	
	@Autowired
	private ProductRepository productrepo;
	
	@Override
	public Mono<Cart> createdCart(CreateCartRequest request) {
		Cart cart = Cart.builder().id(request.getCartId()).build();
		return cartrepo.save(cart);
	}

	@Override
	public Mono<Cart> addProductToCart(AddProductToCartRequest request) {
		return Mono.zip(
				objects -> addOrUpdateProductInCart((Cart) objects[0],(Product) objects[1], request.getQuantity()),
				cartrepo.findById(request.getCartId()),
				productrepo.findById(request.getProductId())
		).flatMap(cart -> cartrepo.save(cart));
	}

	private Cart addOrUpdateProductInCart(Cart cart, Product product, Integer quantity){
		if(isCartContainProduct(cart, product)){
			incrementProductQuantity(cart, product, quantity);
		}else {
			addNewProductToCart(cart, product, quantity);
		}
		return cart;
	}

	private boolean isCartContainProduct(Cart cart, Product product){
		return cart.getItems().stream()
				.anyMatch(cartItem ->  cartItem.getId().equals(product.getId()));
	}

	private void incrementProductQuantity(Cart cart, Product product, Integer quantity){
		cart.getItems().stream()
				.filter(cartItem -> cartItem.getId().equals(product.getId()))
				.forEach(cartItem -> cartItem.setQuantity(cartItem.getQuantity() + quantity));
	}

	private void addNewProductToCart(Cart cart, Product product, Integer quantity){
		CartItem item = new CartItem(product.getId(),
				product.getName(), product.getPrice(), quantity);
		cart.getItems().add(item);
	}

	@Override
	public Mono<Cart> cartDetail(GetCartDetailRequest request) {
		return cartrepo.findById(request.getCartId());
	}

	@Override
	public Mono<Cart> updateProductInCart(UpdateProductInCartRequest request) {
		return Mono.zip(
				objects -> updateCartItemQuantity((Cart)objects[0], (Product)objects[1], request.getQuantity()),
				cartrepo.findById(request.getCartId()),
				productrepo.findById(request.getProductId())
		).flatMap(cart -> cartrepo.save(cart));
	}

	private Cart updateCartItemQuantity(Cart cart, Product product, Integer quantity){
		cart.getItems().stream()
				.filter(cartItem -> cartItem.getId().equals(product.getId()))
				.forEach(cartItem -> cartItem.setQuantity(cartItem.getQuantity() + quantity));
		return cart;
	}


	@Override
	public Mono<Cart> deleteProductInCart(DeleteProductInCartRequest request) {
		return Mono.zip(
				objects -> deleteItemFromCart((Cart)objects[0],
						findItemCart((Cart) objects[0],request.getProductId())),
				cartrepo.findById(request.getCartId())
		).flatMap(cart -> cartrepo.save(cart));
	}

	private CartItem findItemCart(Cart cart, String productId){
		return cart.getItems().stream()
				.filter(cartItem -> cartItem.getId().equals(productId))
				.findFirst()
				.get();
	}

	private Cart deleteItemFromCart(Cart cart, CartItem cartItem){
		cart.getItems().remove(cartItem);
		return cart;
	}

}
