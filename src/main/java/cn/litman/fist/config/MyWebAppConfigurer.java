package cn.litman.fist.config;

import cn.litman.fist.interceptor.ConfInterceptor;
import cn.litman.fist.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 注册拦截器
 * @author SoyungTong
 * @email litman@126.com
 * @date 2021/5/1 17:07
 */
@Configuration
public class MyWebAppConfigurer implements WebMvcConfigurer {

    @Bean
    public ConfInterceptor confInterceptor() {
        return new ConfInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // addPathPatterns 添加拦截路径, excludePathPatterns 排除拦截路径
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/fist/**", "/**/**/verify");
        registry.addInterceptor(confInterceptor()).addPathPatterns("/**").excludePathPatterns("/static/*");
    }
}
