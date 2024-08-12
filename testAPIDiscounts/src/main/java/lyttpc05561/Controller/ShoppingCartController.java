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
import lyttpc05561.Model.ShoppingCart;
import lyttpc05561.Reponsitory.CartItemsRepository;
import lyttpc05561.Reponsitory.ShoppingCartsRepository;


@RestController
@RequestMapping("/api/shoppingCart")
public class ShoppingCartController {

	@Autowired
     ShoppingCartsRepository shoppingCartsRepository ;

    @GetMapping
    public List<ShoppingCart> getAllDiscounts() {
        return shoppingCartsRepository.findAll();
    }

    @GetMapping("/{id}")
    public ShoppingCart getShoppingCartId(@PathVariable int id) {
        return shoppingCartsRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("ShoppingCart not found with id " + id));
    }

    @PostMapping
    public ShoppingCart createShoppingCart(@RequestBody ShoppingCart shoppingCart) {
        return shoppingCartsRepository.save(shoppingCart);
    }

    @PutMapping("/{id}")
    public ShoppingCart updateCartItems(@PathVariable int id, @RequestBody ShoppingCart shoppingCartDetails) {
    	ShoppingCart shoppingCart = shoppingCartsRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("ShoppingCart not found with id " + id));
    	shoppingCart.setCartId(shoppingCartDetails.getCartId());
    	shoppingCart.setTotalPrice(shoppingCartDetails.getTotalPrice());
    	shoppingCart.setFinalPrice(shoppingCartDetails.getFinalPrice());
    	shoppingCart.setUsers_id(shoppingCartDetails.getUsers_id());
       
        return shoppingCartsRepository.save(shoppingCart);
    }

    @DeleteMapping("/{id}")
    public void deleteCategories(@PathVariable int id) {
    	ShoppingCart shoppingCart = shoppingCartsRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("ShoppingCart not found with id " + id));
    	shoppingCartsRepository.delete(shoppingCart);
    }
}
