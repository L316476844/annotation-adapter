package org.jon.lv.annotation;

import java.lang.annotation.*;

/**
 * 权限
 * @author jon lv
 * @date
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Auth {

    /**
     * 登陆拦截 (默认拦截)
     */
    boolean verifyLogin() default true;

    /**
     * 权限验证 （默认不拦截）
     */
    boolean verifyURL() default false;
}
