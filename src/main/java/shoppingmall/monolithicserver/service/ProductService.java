package shoppingmall.monolithicserver.service;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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
    private final ProductRepository productRepository;

    public List<ProductDto> findAllProducts() {
        List<Product> products = Optional.of(productRepository.findAll()).orElseThrow(
                () -> new EntityNotFoundException("Not Found Products"));

        return products
                .stream()
                .map(ProductDto.ProductList::new)
                .collect(Collectors.toList());
    }

    @Transactional(rollbackFor = Exception.class)
    public List<Long> registerProducts(List<ProductDto.ProductUpsert> productsDto) {
        List<Product> products;
        products = productsDto
                .stream()
                .map(item -> new Product(null, item))
                .collect(Collectors.toList());

        productRepository.saveAll(products);

        return products
                .stream()
                .map(Product::getId)
                .collect(Collectors.toList());
    }

    @Transactional(rollbackFor = Exception.class)
    public void updatedProduct(Long productId, ProductDto.ProductUpsert productDto) {
        Product product = new Product(productId, productDto);
        productRepository.save(product);
    }

    @Transactional(rollbackFor = Exception.class)
    public void deleteProduct(Long productId) {
        Product product = productRepository.findById(productId).orElseThrow(
                () -> new EntityNotFoundException("Not Found ProductId " + productId)
        );

        product.deleteData();
        productRepository.save(product);
    }
}
