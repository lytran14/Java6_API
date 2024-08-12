package lyttpc05561.Controller;

import lyttpc05561.Exception.ResourceNotFoundException;
import lyttpc05561.Model.Discount;
import lyttpc05561.Reponsitory.DiscountRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/discounts")
public class DiscountController {

    @Autowired
    DiscountRepository discountRepository;

    @GetMapping
    public List<Discount> getAllDiscounts() {
        return discountRepository.findAll();
    }

    @GetMapping("/{id}")
    public Discount getDiscountById(@PathVariable int id) {
        return discountRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Discount not found with id " + id));
    }

    @PostMapping
    public Discount createDiscount(@RequestBody Discount discount) {
        return discountRepository.save(discount);
    }

    @PutMapping("/{id}")
    public Discount updateDiscount(@PathVariable int id, @RequestBody Discount discountDetails) {
        Discount discount = discountRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Discount not found with id " + id));
        discount.setDiscountCode(discountDetails.getDiscountCode());
        discount.setQuantity(discountDetails.getQuantity());
        discount.setDiscount_type_id(discountDetails.getDiscount_type_id());
        discount.setDiscountValue(discountDetails.getDiscountValue());
        discount.setStartDate(discountDetails.getStartDate());
        discount.setEndDate(discountDetails.getEndDate());
        discount.setMinInvoiceAmount(discountDetails.getMinInvoiceAmount());
        discount.setStatus_id(discountDetails.getStatus_id());
        return discountRepository.save(discount);
    }

    @DeleteMapping("/{id}")
    public void deleteDiscount(@PathVariable int id) {
        Discount discount = discountRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Discount not found with id " + id));
        discountRepository.delete(discount);
    }
}
