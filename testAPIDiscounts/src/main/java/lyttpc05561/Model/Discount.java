package lyttpc05561.Model;


import java.util.Date;

import jakarta.persistence.Column;
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
@Table(name = "Discounts")
public class Discount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int discountId;

    @Column(name = "discount_code", length = 50)
    private String discountCode;

    @Column(name = "quantity", nullable = false)
    private int quantity;

//    @ManyToOne
    @JoinColumn(name = "discount_type_id", nullable = false)
    private Integer discount_type_id;

    @Column(name = "discount_value", nullable = false)
    private float discountValue;

    @Column(name = "start_date", nullable = false)
    private Date startDate;

    @Column(name = "end_date", nullable = false)
    private Date endDate;

    @Column(name = "min_invoice_amount", nullable = false)
    private float minInvoiceAmount;

//    @ManyToOne
    @JoinColumn(name = "status_id", nullable = false)
    private Integer status_id;

    // Getters and Setters
}

