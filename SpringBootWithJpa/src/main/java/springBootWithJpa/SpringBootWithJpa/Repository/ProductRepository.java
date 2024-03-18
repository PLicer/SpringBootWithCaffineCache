package springBootWithJpa.SpringBootWithJpa.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import springBootWithJpa.SpringBootWithJpa.Entity.Product;

import java.util.List;

public  interface ProductRepository extends JpaRepository<Product,Integer> {

    List<Product> findByPriceBetween(int i, int i1);
}
