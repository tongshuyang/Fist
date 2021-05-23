package cn.litman.fist.controller;

import cn.litman.fist.common.PageMsg;
import cn.litman.fist.common.ReturnMsg;
import cn.litman.fist.entity.WebConfig;
import cn.litman.fist.service.WebConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;

/**
 * 网站配置控制器
 * @author SoyungTong
 * @email litman@126.com
 * @date 2021/5/2 16:50
 */
@Controller
@RequestMapping("/conf")
public class WebConfigController {
    @Autowired
    private WebConfigService webConfigService;

    /**
     * 网站配置管理视图
     *
     * @return java.lang.String
     * @author SoyungTong
     * @date 2021/5/2 16:50
     */
    @GetMapping("/conf_manage_view/verify")
    public String confManageView(){
        return "conf_manage";
    }

    /**
     * 获取网站配置列表
     *
     * @param webConfig 网站配置实体类
     * @param page 页码
     * @param limit 每页数据量
     * @return cn.litman.fist.common.PageMsg
     * @author SoyungTong
     * @date 2021/5/2 16:53
     */
    @ResponseBody
    @GetMapping("/list_conf/verify")
    public PageMsg listConf(WebConfig webConfig, Integer page, Integer limit){
        return webConfigService.listConf(webConfig,page,limit);
    }

    /**
     * 修改网站配置
     *
     * @param webConfig 网站配置实体类
     * @param request 请求
     * @return cn.litman.fist.common.ReturnMsg
     * @author SoyungTong
     * @date 2021/5/2 17:05
     */
    @ResponseBody
    @PostMapping("/alt_conf/verify")
    public ReturnMsg altConf(WebConfig webConfig, HttpServletRequest request) {
        return webConfigService.altConf(webConfig, request);
    }
}
