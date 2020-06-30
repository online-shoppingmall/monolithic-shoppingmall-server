package shoppingmall.monolithicserver.common;

import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.Collection;
import java.util.stream.Collectors;

/**
 * Created by sehajyang
 * DateTime : 2020/06/29
 */
public class Utils {

    public static boolean isEmpty(Object object) {
        if (object instanceof Collection) {
            return CollectionUtils.isEmpty((Collection<?>) object);
        } else if (object instanceof String) {
            return StringUtils.isEmpty(object);
        }
        return ObjectUtils.isEmpty(object);
    }

    public static boolean isNotEmpty(Object object) {
        return !isEmpty(object);
    }
}
