package shoppingmall.monolithicserver.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import shoppingmall.monolithicserver.common.Utils;
import shoppingmall.monolithicserver.model.dto.ProductDto;
import shoppingmall.monolithicserver.model.enums.ProductStatus;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by sehajyang
 * DateTime : 2020/06/29
 */

@Getter
@Setter
@Entity
@Table(name="product")
@NoArgsConstructor
public class Product extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="product_id")
    private Long id;

    private String name;

    @Column(length = 1000)
    private String description;
    private Long price;
    private Long discountPercent;
    private Long stockCount;
    private Long saveStockCount;

    @ManyToMany(mappedBy = "products")
    private Set<Category> categories = new LinkedHashSet<>();

    @OneToMany
    private Set<ProductOptionGroup> productOptionGroups = new LinkedHashSet<>();

    @OneToOne
    @JoinColumn(name="file_id")
    private File file;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;
    private ProductStatus status;

    @Column(columnDefinition = "boolean default true")
    private Boolean isExposure;

    public Product(Long productId, ProductDto.ProductUpsert productDto) {
        if(Utils.isNotEmpty(productId)){
            this.id = productId;
        }
        this.name = productDto.getName();
        this.description = productDto.getDescription();
        this.price = productDto.getPrice();
        this.discountPercent = productDto.getDiscountPercent();
        this.stockCount = productDto.getStockCount();
    }
}
