package shoppingmall.monolithicserver.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by sehajyang
 * DateTime : 2020/06/30
 */

@Getter
@Entity
@Table(name="product_option_group")
@NoArgsConstructor
public class ProductOptionGroup extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="product_option_group_id")
    private Long id;

    private String name;

    @OneToMany(cascade = {CascadeType.ALL}, orphanRemoval = true)
    @JoinColumn(name = "product_option_id")
    private Set<ProductOption> productOptions = new LinkedHashSet<>();
}
