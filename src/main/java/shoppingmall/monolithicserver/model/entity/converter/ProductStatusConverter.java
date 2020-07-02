package shoppingmall.monolithicserver.model.entity.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import shoppingmall.monolithicserver.model.enums.ProductStatus;

/**
 * Created by sehajyang
 * DateTime : 2020/07/02
 * Descrpition : Ignore type mismatch exception
 */

@Component
public class ProductStatusConverter implements Converter<String, ProductStatus> {

    @Override
    public ProductStatus convert(String source) {
        try{
            return ProductStatus.valueOf(source);
        }catch (Exception e){
            return null;
        }
    }
}
