package org.jon.lv.annotation;

import java.lang.annotation.*;

/**
 * Token 防止重复提交
 * @author jon lv
 * @date
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Token {
    boolean save() default true;

    boolean remove() default true;
}
