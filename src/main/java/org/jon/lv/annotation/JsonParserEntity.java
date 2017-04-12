package org.jon.lv.annotation;

import java.lang.annotation.*;

/**
 * json 转换实体
 * @author jon lv
 * @date
 */
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface JsonParserEntity {

    /**
     * 待转义参数名称
     * @return
     */
    String value() default "";
}
