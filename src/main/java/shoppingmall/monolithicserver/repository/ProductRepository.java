package shoppingmall.monolithicserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import shoppingmall.monolithicserver.model.entity.Product;

/**
 * Created by sehajyang
 * DateTime : 2020/06/29
 */
public interface ProductRepository extends JpaRepository<Product, Long> {
}
