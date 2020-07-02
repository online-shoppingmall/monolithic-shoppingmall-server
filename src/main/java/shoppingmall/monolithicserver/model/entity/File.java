package shoppingmall.monolithicserver.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import shoppingmall.monolithicserver.model.enums.FileType;

import javax.persistence.*;

/**
 * Created by sehajyang
 * DateTime : 2020/06/30
 */

@Getter
@Setter
@Entity
@Table(name="file")
@NoArgsConstructor
public class File extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="file_id")
    private Long id;

    private String name;
    private String url;
    private Long size;

    @Enumerated(EnumType.STRING)
    private FileType type;
    private String extension;
}
