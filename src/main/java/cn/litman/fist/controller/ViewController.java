package cn.litman.fist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 页面视图控制器
 * @author SoyungTong
 * @email litman@126.com
 * @date 2021/5/2 16:26
 */
@Controller
public class ViewController {

    /**
     * 首页为登录页
     *
     * @return java.lang.String
     * @author SoyungTong
     * @date 2021/5/2 16:26
     */
    @GetMapping("/")
    public String index(){
        return "sign_in";
    }

    /**
     * 模板界面路径
     *
     * @return java.lang.String
     * @author SoyungTong
     * @date 2021/5/2 16:26
     */
    @GetMapping("/fist")
    public String admin(){
        return "framework";
    }

    /**
     * 后台首页
     *
     * @return java.lang.String
     * @author SoyungTong
     * @date 2021/5/2 16:36
     */
    @GetMapping("/home")
    public String home(){
        return "home";
    }

    /**
     * 404页面
     *
     * @return java.lang.String
     * @author Soyung
     * @date 2019/4/14 18:50
     */
    @GetMapping("/not_found")
    public String notFound(){
        return "404";
    }
}
