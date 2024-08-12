package lyttpc05561.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lyttpc05561.Exception.ResourceNotFoundException;
import lyttpc05561.Model.CartItems;
import lyttpc05561.Model.Categories;
import lyttpc05561.Reponsitory.CartItemsRepository;
import lyttpc05561.Reponsitory.CategoriesRepository;

@RestController
@RequestMapping("/api/cartItems")
public class CartItemsController {

	@Autowired
    CartItemsRepository cartItemsRepository ;

    @GetMapping
    public List<CartItems> getAllDiscounts() {
        return cartItemsRepository.findAll();
    }

    @GetMapping("/{id}")
    public CartItems getCartItemsId(@PathVariable int id) {
        return cartItemsRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("CartItems not found with id " + id));
    }

    @PostMapping
    public CartItems createCartItems(@RequestBody CartItems cartItems) {
        return cartItemsRepository.save(cartItems);
    }

    @PutMapping("/{id}")
    public CartItems updateCartItems(@PathVariable int id, @RequestBody CartItems cartItemsDetails) {
    	CartItems cartItems = cartItemsRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("CartItems not found with id " + id));
//    	cartItems.setCartItemId(cartItemsDetails.getCartItemId());
    	cartItems.setQuantity(cartItemsDetails.getQuantity());
    	cartItems.setProductId(cartItemsDetails.getProductId());
    	cartItems.setShoppingCart(cartItemsDetails.getShoppingCart());
       
        return cartItemsRepository.save(cartItems);
    }

    @DeleteMapping("/{id}")
    public void deleteCategories(@PathVariable int id) {
    	CartItems cartItems = cartItemsRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("CartItems not found with id " + id));
    	cartItemsRepository.delete(cartItems);
    }
}
