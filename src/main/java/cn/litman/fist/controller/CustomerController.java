package cn.litman.fist.controller;

import cn.litman.fist.common.Constant;
import cn.litman.fist.common.PageMsg;
import cn.litman.fist.common.ReturnMsg;
import cn.litman.fist.entity.Customer;
import cn.litman.fist.service.CustomerService;
import cn.litman.fist.util.AliOSSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import java.util.HashMap;
import java.util.Map;

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
    @Autowired
    private AliOSSService aliOSSService;

    /**
     * 返回客户信息管理页面
     *
     * @return java.lang.String
     * @author SoyungTong
     * @date 2021/7/6 0:55
     */
    @GetMapping("/customer_manage_view/verify")
    public String customerManageView(){
        return "customer_manage";
    }

    /**
     * 返回客户信息编辑页面
     *
     * @return java.lang.String
     * @author SoyungTong
     * @date 2021/7/8 21:20
     */
    @GetMapping("/edit_customer/verify")
    public String editCustomerView(){
        return "/modal/edit_customer";
    }

    /**
     * 添加客户信息
     *
     * @param customer 客户实体类
     * @return cn.litman.fist.common.ReturnMsg
     * @author SoyungTong
     * @date 2021/6/29 22:42
     */
    @ResponseBody
    @PostMapping("/add_customer/verify")
    public ReturnMsg addCustomer(Customer customer){
        return customerService.addCustomer(customer);
    }

    /**
     * 编辑器上传图片接口
     *
     * @param file 图片文件流数据
     * @return cn.litman.fist.common.ReturnMsg
     * @author SoyungTong
     * @date 2021/7/20 0:27
     */
    @ResponseBody
    @PostMapping("/upload_edit_img/verify")
    public PageMsg uploadEditImg(MultipartFile file) throws Exception{
        Map<String,Object> map = new HashMap<>(3);
        map.put("src", Constant.ENDPOINT + aliOSSService.fileUpload(file,Constant.IMG_UPLOAD_PATH));
        map.put("title","Edit Img");
        return new PageMsg(0L, map);
    }
    /**
     * 查询客户信息
     *
     * @param customer 客户实体类
     * @param page 页数
     * @param limit 每页条数
     * @return cn.litman.fist.common.PageMsg
     * @author SoyungTong
     * @date 2021/6/29 22:47
     */
    @ResponseBody
    @GetMapping("/list_customer/verify")
    public PageMsg listCustomer(Customer customer, Integer page, Integer limit) {
        return customerService.listCustomer(customer,page,limit);
    }

    /**
     * 修改客户信息
     *
     * @param customer 客户实体类
     * @return cn.litman.fist.common.ReturnMsg
     * @author SoyungTong
     * @date 2021/6/29 22:50
     */
    @ResponseBody
    @PostMapping("/alt_customer/verify")
    public ReturnMsg altCustomer(Customer customer) {
        return customerService.altCustomer(customer);
    }
}
