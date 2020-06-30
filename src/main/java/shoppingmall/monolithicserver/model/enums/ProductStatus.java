package shoppingmall.monolithicserver.model.enums;

import lombok.AllArgsConstructor;

/**
 * Created by sehajyang
 * DateTime : 2020/06/30
 */

@AllArgsConstructor
public enum ProductStatus {
    OPEN("1", "판매중"),
    PENDING("2", "판매대기중"),
    CLOSE("3", "판매중지"),
    SOLD_OUT("4", "판매완료");

    private String code;
    private String description;
}
