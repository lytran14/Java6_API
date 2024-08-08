package lyttpc05561.Reponsitory;

import org.springframework.data.jpa.repository.JpaRepository;

import lyttpc05561.Model.Discount;

public interface DiscountRepository extends JpaRepository<Discount, Integer> {
    // Custom query methods can be added here if needed
}

