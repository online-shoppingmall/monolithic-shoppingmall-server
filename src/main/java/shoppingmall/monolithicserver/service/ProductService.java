package shoppingmall.monolithicserver.service;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import shoppingmall.monolithicserver.model.dto.ProductDto;
import shoppingmall.monolithicserver.model.entity.Product;
import shoppingmall.monolithicserver.repository.ProductRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by sehajyang
 * DateTime : 2020/06/29
 */

@Service
@RequiredArgsConstructor
public class ProductService {
    ProductRepository productRepository;

    public List<ProductDto> findAllProducts() {
        List<Product> products = Optional.of(productRepository.findAll())
                .orElseThrow(() -> new EntityNotFoundException("Not Found Products"));

        return products.stream()
                .map(ProductDto.ProductList::new)
                .collect(Collectors.toList());
    }
}
