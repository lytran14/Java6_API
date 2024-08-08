package lyttpc05561.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "Discountsstatus")
public class DiscountStatus {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int statusId;

    private String statusName;



}
