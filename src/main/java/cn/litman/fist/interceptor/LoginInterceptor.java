package cn.litman.fist.interceptor;

import cn.litman.fist.common.Constant;
import cn.litman.fist.entity.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;

/**
 * 身份验证拦截器
 * @author SoyungTong
 * @email litman@126.com
 * @date 2021/5/1 17:07
 */
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //在请求处理之前进行调用（Controller方法调用之前）
        // 只有返回true才会继续向下执行，返回false取消当前请求
        String path = request.getServletPath();
        User userSession = (User) request.getSession().getAttribute(Constant.USER_SESSION);
        if(path.startsWith("/user/") || path.startsWith("/conf/")){
            if(userSession == null || userSession.getRole() == 0){
                response.sendRedirect("/");
                return false;
            }
        }else if(userSession == null){
            response.sendRedirect("/");
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        //请求处理之后进行调用，但是在视图被渲染之前（Controller方法调用之后）
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        //在整个请求结束之后被调用，也就是在DispatcherServlet 渲染了对应的视图之后执行（主要是用于进行资源清理工作）
    }
}
