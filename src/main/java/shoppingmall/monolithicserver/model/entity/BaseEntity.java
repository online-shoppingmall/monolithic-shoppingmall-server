package shoppingmall.monolithicserver.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import shoppingmall.monolithicserver.common.Utils;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Created by sehajyang
 * DateTime : 2020/06/30
 */

@Getter
@NoArgsConstructor
@MappedSuperclass
public abstract class BaseEntity {

    @JsonIgnore
    @Column(name="created_at", updatable = false)
    private LocalDateTime createdAt;

    @JsonIgnore
    @Column(name="updated_at", updatable = false)
    private LocalDateTime updatedAt;

    @JsonIgnore
    @Column(name="delete_at", updatable = false)
    private LocalDateTime deletedAt;

//    @Column(name="created_by")
//    private Long createdBy;

//    @Column(name="updated_by")
//    private Long updatedBy;

    @PrePersist
    public void setPrePersist() {
        if (Utils.isEmpty(this.createdAt)) {
            this.createdAt = LocalDateTime.now();
        }
        this.updatedAt = LocalDateTime.now();
        this.deletedAt = null;
    }
}
