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
import lyttpc05561.Model.Categories;
import lyttpc05561.Reponsitory.CategoriesRepository;

@RestController
@RequestMapping("/api/categories")
public class CategoriesController {

	@Autowired
    CategoriesRepository categoriesRepository;

    @GetMapping
    public List<Categories> getAllDiscounts() {
        return categoriesRepository.findAll();
    }

    @GetMapping("/{id}")
    public Categories getCategoriesId(@PathVariable int id) {
        return categoriesRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Discount not found with id " + id));
    }

    @PostMapping
    public Categories createCategories(@RequestBody Categories categories) {
        return categoriesRepository.save(categories);
    }

    @PutMapping("/{id}")
    public Categories updateCategories(@PathVariable int id, @RequestBody Categories categoriesDetails) {
    	Categories categories = categoriesRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Discount not found with id " + id));
    	categories.setStatusId(categoriesDetails.getStatusId());
    	categories.setCategoryName(categoriesDetails.getCategoryName());
       
        return categoriesRepository.save(categories);
    }

    @DeleteMapping("/{id}")
    public void deleteCategories(@PathVariable int id) {
    	Categories categories = categoriesRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Discount not found with id " + id));
    	categoriesRepository.delete(categories);
    }
}
