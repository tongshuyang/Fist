package cn.litman.fist.config;

import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.ErrorPageRegistrar;
import org.springframework.boot.web.server.ErrorPageRegistry;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

/**
 * 错误页面配置
 * @author SoyungTong
 * @email litman@126.com
 * @date 2021/5/1 17:01
 */
@Component
public class ErrorConfig implements ErrorPageRegistrar {

    @Override
    public void registerErrorPages(ErrorPageRegistry registry) {
        ErrorPage error404Page = new ErrorPage(HttpStatus.NOT_FOUND, "/notFound");
        registry.addErrorPages(error404Page);
    }
}
