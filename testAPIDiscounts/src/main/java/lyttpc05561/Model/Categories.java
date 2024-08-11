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
@Table(name = "Categories")
public class Categories {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int categoryId;

    @ManyToOne
    @JoinColumn(name = "status_id", nullable = false)
    private CategoriesStatus categoriesStatus;
    
    @Column(name = "category_name", nullable = false)
    private String categoryName;

}
