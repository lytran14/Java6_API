package lyttpc05561.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "Discounttypes")
public class DiscountType {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int discountTypeId;

    private String discountTypeName;

    @ManyToOne
    @JoinColumn(name = "status_id", nullable = false)
    private DiscountTypesStatus status;
}
