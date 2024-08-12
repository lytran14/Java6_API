package lyttpc05561.Reponsitory;

import org.springframework.data.jpa.repository.JpaRepository;

import lyttpc05561.Model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>  {

}
