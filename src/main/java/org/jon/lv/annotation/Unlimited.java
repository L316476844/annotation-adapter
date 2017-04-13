package org.jon.lv.annotation;

import java.lang.annotation.*;

/**
 * 无限制--使用此注解该方法不在做任何校验处理
 * @author jon lv
 * @date
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Unlimited {
}
