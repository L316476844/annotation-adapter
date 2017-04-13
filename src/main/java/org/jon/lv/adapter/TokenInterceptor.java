package org.jon.lv.adapter;

import org.jon.lv.annotation.Token;
import org.jon.lv.exception.TokenException;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.UUID;

/**
 * 防止重复提交过滤器
 */
public class TokenInterceptor extends HandlerInterceptorAdapter
{
    private static final String COOKIE_LOGIN_DOMAIN = ".baidu.com";
    private static final String TOKEN_KEY = "x-token";
    private static final int COOKIE_MAXAGE = 60 * 20;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception
    {
        if (handler instanceof HandlerMethod)
        {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            Method method = handlerMethod.getMethod();
            Token annotation = method.getAnnotation(Token.class);

            if (annotation != null)
            {
                boolean needSaveSession = annotation.save();

                if (needSaveSession)
                {
                    setToken(request, response);
                }

                boolean needRemoveSession = annotation.remove();

                if (needRemoveSession)
                {
                    if (isRepeatSubmit(request))
                    {
                        return false;
                    }

                    request.getSession(false).removeAttribute(TOKEN_KEY);
                }
            }

            return true;
        }
        else
        {
            return super.preHandle(request, response, handler);
        }
    }

    private boolean isRepeatSubmit(HttpServletRequest request) throws TokenException
    {
        String serverToken = (String) request.getSession(false).getAttribute(TOKEN_KEY);

//        if (StringUtils.isBlank(serverToken))
//        {
//            throw new TokenException("对不起，提交失败，请重试！");
//        }
//
//        String clinetToken = CookieUtils.getCookieByName(request, TOKEN_KEY);
//
//        if (StringUtils.isBlank(clinetToken))
//        {
//            throw new TokenException("对不起，您长时间没有操作，请重试！");
//        }
//        if (!serverToken.equals(clinetToken))
//        {
//        	throw new TokenException("对不起，请刷新后重试！");
//        }

        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception
    {
        super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception e) throws Exception
    {
        super.afterCompletion(request, response, handler, e);

        if (e != null && !(e instanceof TokenException))
        {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            Method method = handlerMethod.getMethod();
            Token annotation = method.getAnnotation(Token.class);

            if (annotation != null)
            {
                boolean isRemoved = annotation.remove();

                if (isRemoved)
                {
                    setToken(request, response);
                }
            }
        }
    }

    private void setToken(HttpServletRequest request, HttpServletResponse response)
    {
        String token = UUID.randomUUID().toString();
        request.getSession(false).setAttribute(TOKEN_KEY, token);
//        CookieUtils.addCookie(response, false, COOKIE_LOGIN_DOMAIN, "/", TOKEN_KEY, token, COOKIE_MAXAGE);
    }

}