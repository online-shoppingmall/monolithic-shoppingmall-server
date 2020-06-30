package shoppingmall.monolithicserver.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;

/**
 * Created by sehajyang
 * DateTime : 2020/06/29
 */

@Getter
@NoArgsConstructor
//@Audited
public class Product extends BaseEntity{

    @Id
    @Column(name="product_id")
    private Long id;

    private String name;
    private String description;

}
