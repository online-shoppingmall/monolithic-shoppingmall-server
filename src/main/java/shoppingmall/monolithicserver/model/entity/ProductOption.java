package shoppingmall.monolithicserver.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by sehajyang
 * DateTime : 2020/06/30
 * Descrpition :
 */

@Getter
@Setter
@Entity
@Table(name="product_option")
@NoArgsConstructor
public class ProductOption {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="product_option_id")
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name="product_option_group_id")
    private ProductOptionGroup productOptionGroup;

}
