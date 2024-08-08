package lyttpc05561.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lyttpc05561.Exception.ResourceNotFoundException;
import lyttpc05561.Model.Discount;
import lyttpc05561.Reponsitory.DiscountRepository;

@Service
public class DiscountService {

    @Autowired
    private DiscountRepository discountRepository;

    public List<Discount> getAllDiscounts() {
        return discountRepository.findAll();
    }

    public Optional<Discount> getDiscountById(int id) {
        return discountRepository.findById(id);
    }

    public Discount createDiscount(Discount discount) {
        return discountRepository.save(discount);
    }

    public Discount updateDiscount(int id, Discount discountDetails) {
        Discount discount = discountRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Discount not found"));

        discount.setDiscountCode(discountDetails.getDiscountCode());
        discount.setQuantity(discountDetails.getQuantity());
        discount.setDiscountType(discountDetails.getDiscountType());
        discount.setDiscountValue(discountDetails.getDiscountValue());
        discount.setStartDate(discountDetails.getStartDate());
        discount.setEndDate(discountDetails.getEndDate());
        discount.setMinInvoiceAmount(discountDetails.getMinInvoiceAmount());
        discount.setStatus(discountDetails.getStatus());

        return discountRepository.save(discount);
    }

    public void deleteDiscount(int id) {
        Discount discount = discountRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Discount not found"));
        discountRepository.delete(discount);
    }
}
