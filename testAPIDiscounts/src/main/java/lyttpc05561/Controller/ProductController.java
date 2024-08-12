package lyttpc05561.Controller;

import org.springframework.web.bind.annotation.RestController;

import lyttpc05561.Exception.ResourceNotFoundException;
import lyttpc05561.Model.Product;
import lyttpc05561.Model.ProductStatus;
import lyttpc05561.Reponsitory.ProductRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
@RestController
@RequestMapping("/api/product")
public class ProductController {
	@Autowired
	ProductRepository productRepository;

	@RequestMapping
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	@GetMapping("/{id}")
	public Product getProductById(@PathVariable int id) {
		return productRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Product not found wiht id " + id));
	}

	@PostMapping
	public Product crateProduct(@RequestBody Product product) {
		return productRepository.save(product);
	}

	@PutMapping("/{id}")
	public Product updatePoroduct(@PathVariable int id, @RequestBody Product product) {
		Product product2 = productRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Product not found wiht id " + id));
		product2.setProductId(product.getProductId());
		product2.setProductName(product.getProductName());
		product2.setDiscountPercentage(product.getDiscountPercentage());
		product2.setPrice(product.getPrice());
		product2.setPublishingYear(product.getPublishingYear());
		product2.setWeight(product.getWeight());
		product2.setSize(product.getSize());
		product2.setNumberOfPages(product.getNumberOfPages());
		product2.setAuthor(product.getAuthor());
		product2.setDescription(product.getDescription());
		product2.setManufacturer(product.getManufacturer());
		product2.setPostingDate(product.getPostingDate());
		product2.setCategory(product.getCategory());
		product2.setImageId(product.getImageId());
		product2.setStatus(product.getStatus());
		return productRepository.save(product2);
	}
	@DeleteMapping("/{id}")
	public void deleteProduct(@PathVariable int id) {
		Product product = productRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Product not found wiht id " + id));
		 productRepository.delete(product);
	}
}
