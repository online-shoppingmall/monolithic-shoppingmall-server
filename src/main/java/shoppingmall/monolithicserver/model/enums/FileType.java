package shoppingmall.monolithicserver.model.enums;

import lombok.AllArgsConstructor;

/**
 * Created by sehajyang
 * DateTime : 2020/06/30
 * Descrpition :
 */

@AllArgsConstructor
public enum FileType {
    IMAGE_JPEG("image/jpeg"),
    IMAGE_PNG("image/png"),
    IMAGE_JPG("image/jpg"),
    IMAGE_GIF("image/gif");

    private String value;
}
