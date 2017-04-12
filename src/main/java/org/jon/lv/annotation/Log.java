package org.jon.lv.annotation;

import java.lang.annotation.*;

/**
 * 记录业务日志
 * @author jon lv
 * @date
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Log {

    String value() default "";
}
