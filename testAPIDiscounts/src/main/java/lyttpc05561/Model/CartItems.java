package lyttpc05561.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "Cartitems")
public class CartItems {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)  
	    private Integer cartItemId;

	    @Column(name = "quantity", nullable = false)
	    private Integer quantity;

	    @JoinColumn(name = "product_id", nullable = false)
	    private Integer productId;
	    
	    @ManyToOne
	    @JoinColumn(name = "cartId", referencedColumnName = "cartId", nullable = false)
	    private ShoppingCart shoppingCart;
	    
}
