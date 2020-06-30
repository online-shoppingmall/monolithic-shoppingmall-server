package shoppingmall.monolithicserver.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.LinkedHashSet;

/**
 * Created by sehajyang
 * DateTime : 2020/06/29
 */

@Entity
@Table(name="product")
@Getter
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

    @ManyToMany
    private Set<Category> categories = new LinkedHashSet<>();

    @OneToMany
    private Set<ProductOptionGroups> productOptionGroups = new LinkedHashSet<>();

    @OneToOne
    @JoinColumn(name="file_id")
    private File file;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;
    private ProductStatus status;

    @Column(columnDefinition = "boolean default true")
    private Boolean isExposure;
}
