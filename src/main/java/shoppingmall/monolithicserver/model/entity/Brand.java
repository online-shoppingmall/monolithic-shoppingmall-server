package shoppingmall.monolithicserver.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by sehajyang
 * DateTime : 2020/06/30
 */

@Getter
@Setter
@Entity
@Table(name="brand")
@NoArgsConstructor
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="brand_id")
    private Long id;

    private String name;

    @Column(length = 1000)
    private String description;

    @OneToOne
    @JoinColumn(name="file_id")
    private File file;
}
