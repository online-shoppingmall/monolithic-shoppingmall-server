package shoppingmall.monolithicserver.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import shoppingmall.monolithicserver.model.dto.ProductDto;
import shoppingmall.monolithicserver.service.ProductService;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by sehajyang
 * DateTime : 2020/06/29
 */

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public List<ProductDto> findAllProducts(){
        return productService.findAllProducts();
    }

    @PostMapping
    public List<Long> registerProducts(@Valid @RequestBody List<ProductDto.ProductUpsert> productDto){
        return productService.registerProducts(productDto);
    }

    @PutMapping("/productId")
    public void updatedProduct(@PathVariable("productId") Long productId,
                                @Valid @RequestBody ProductDto.ProductUpsert productDto){
        productService.updatedProduct(productId, productDto);
    }

    @DeleteMapping("/productId")
    public void deleteProduct(@PathVariable("productId") Long productId){
        productService.deleteProduct(productId);
    }
}
