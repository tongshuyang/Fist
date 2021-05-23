package cn.litman.fist.interceptor;

import cn.litman.fist.common.Constant;
import cn.litman.fist.entity.WebConfig;
import cn.litman.fist.mapper.WebConfigMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 网站配置放入application
 * @author SoyungTong
 * @email litman@126.com
 * @date 2021/5/1 17:06
 */
public class ConfInterceptor implements HandlerInterceptor {
    @Autowired
    private WebConfigMapper webConfigMapper;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        ServletContext application = request.getServletContext();
        //加载网站配置信息
        if(application.getAttribute(Constant.CONF_SESSION) == null){
            //查询公开的conf信息
            List<WebConfig> webConfigs = webConfigMapper.listPubConf();
            //放入application中
            Map<String,String> conf = new HashMap<>(20);
            for (WebConfig webConfig:webConfigs
            ) {
                conf.put(webConfig.getKey(),webConfig.getValue());
            }
            application.setAttribute(Constant.CONF_SESSION, conf);
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
