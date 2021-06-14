package cn.litman.fist.controller;

import cn.litman.fist.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author SoyungTong
 * @email litman@126.com
 * @date 2021/5/2 0:50
 */
@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;


}
