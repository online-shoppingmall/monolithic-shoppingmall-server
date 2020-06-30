package shoppingmall.monolithicserver.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import shoppingmall.monolithicserver.model.entity.Product;
import shoppingmall.monolithicserver.model.enums.ProductStatus;

/**
 * Created by sehajyang
 * DateTime : 2020/06/29
 */

@Getter
@Setter
@NoArgsConstructor
public class ProductDto {
    private Long productId;
    private String name;
    private String description;
    private Long price;
    private Long discountPercent;
    private Long stockCount;
    private ProductStatus status;
    private Boolean isExposure;

    public ProductDto(Product product) {
        this.productId = product.getId();
        this.name = product.getName();
        this.description = product.getDescription();
        this.price = product.getPrice();
        this.discountPercent = product.getDiscountPercent();
        this.stockCount = product.getStockCount();
        this.status = product.getStatus();
        this.isExposure = product.getIsExposure();
    }

    @NoArgsConstructor
    public static class ProductList extends ProductDto {
        public ProductList(Product product) {
            super(product);
        }
    }

    @Getter
    @NoArgsConstructor
    public static class ProductUpsert {
        private String name;
        private String description;
        private Long price;
        private Long stockCount;
        private Long discountPercent;
        private ProductStatus status;
        private Boolean isExposure;

        public ProductUpsert(Product product) {
            this.name = product.getName();
            this.description = product.getDescription();
            this.price = product.getPrice();
            this.discountPercent = product.getDiscountPercent();
            this.stockCount = product.getStockCount();
            this.status = product.getStatus();
            this.isExposure = product.getIsExposure();
        }
    }
}
