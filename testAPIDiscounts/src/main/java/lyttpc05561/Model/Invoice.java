package lyttpc05561.Model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Invoices")
public class Invoice {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer invoiceId;

	@Column(nullable = false)
	private Double totalAmount;

	@Column(nullable = false)
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date paymentDate;

//	@Column(nullable = false)
//	private String paymentStatus;

	@JoinColumn(name = "users_id", nullable = false)
	private Integer users_id;

	@JoinColumn(name = "status_id", nullable = false)
	private Integer status_id;

	@JoinColumn(name = "payment_method_id", nullable = false)
	private Integer payment_method_id;

	@JoinColumn(name = "shipping_id", nullable = false)
	private Integer shipping_id;

	@JoinColumn(name = "discount_id", nullable = true)
	private Integer discount_id;
}