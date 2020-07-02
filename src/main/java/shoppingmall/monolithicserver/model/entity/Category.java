package shoppingmall.monolithicserver.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by sehajyang
 * DateTime : 2020/06/30
 */
@Getter
@Setter
@Entity
@Table(name="category")
public class Category extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="category_id")
    private Long id;

    private String name;
    private String code;

    @ManyToMany
    private Set<Product> products = new LinkedHashSet<>();
}
