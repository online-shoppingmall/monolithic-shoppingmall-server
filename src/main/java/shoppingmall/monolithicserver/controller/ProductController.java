package shoppingmall.monolithicserver.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import shoppingmall.monolithicserver.model.dto.ProductDto;
import shoppingmall.monolithicserver.service.ProductService;

import java.util.List;

/**
 * Created by sehajyang
 * DateTime : 2020/06/29
 */

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public List<ProductDto> findAllProducts(){
        return productService.findAllProducts();
    }
}
