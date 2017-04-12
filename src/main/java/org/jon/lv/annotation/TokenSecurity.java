package org.jon.lv.annotation;

import java.lang.annotation.*;

/**
 * Token安全校验
 * @author jon lv
 * @date
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TokenSecurity {

}
