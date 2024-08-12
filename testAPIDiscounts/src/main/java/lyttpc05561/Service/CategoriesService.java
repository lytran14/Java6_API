package lyttpc05561.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lyttpc05561.Exception.ResourceNotFoundException;
import lyttpc05561.Model.Categories;
import lyttpc05561.Reponsitory.CategoriesRepository;

@Service
public class CategoriesService {

	@Autowired
	private CategoriesRepository categoriesRepository;
	
	public List<Categories> getAllDiscounts() {
        return categoriesRepository.findAll();
    }

    public Optional<Categories> getDiscountById(int id) {
        return categoriesRepository.findById(id);
    }

    public Categories createcategories(Categories categories) {
        return categoriesRepository.save(categories);
    }

    public Categories updatecategories(int id, Categories categoriesDetails) {
    	Categories categories = categoriesRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Discount not found"));

    	categories.setCategoriesStatus(categoriesDetails.getCategoriesStatus());
    	categories.setCategoryName(categoriesDetails.getCategoryName());
    	

        return categoriesRepository.save(categories);
    }

    public void deleteDiscount(int id) {
    	Categories categories = categoriesRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Discount not found"));
    	categoriesRepository.delete(categories);
    }
}
