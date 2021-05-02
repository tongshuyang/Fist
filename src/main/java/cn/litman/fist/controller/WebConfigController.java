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
 * @author Soyung
 * @email tsyon@qq.com
 * @date 2019/3/27 13:15
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
     * @author Soyung
     * @date 2019/4/26 17:52
     */
    @GetMapping("/rms/conf_manage")
    public String webConfigManage(){
        return "rms/conf_manage";
    }
    /**
     * 获取网站配置列表
     *
     * @param webConfig 网站配置实体类
     * @param page 页码
     * @param limit 每页数据量
     * @return com.xrdkx.website.common.PageMsg
     * @author Soyung
     * @date 2019/4/26 8:58
     */
    @ResponseBody
    @GetMapping("/rms/list_conf")
    public PageMsg getWebConfigList(WebConfig webConfig, Integer page, Integer limit){
        return webConfigService.getWebConfigList(webConfig,page,limit);
    }

    /**
     * 修改网站配置
     *
     * @param webConfig 网站配置实体类
     * @param request 请求
     * @return com.xrdkx.website.common.ReturnMsg
     * @author Soyung
     * @date 2019/4/26 11:48
     */
    @ResponseBody
    @PostMapping("/rms/alt_conf")
    public ReturnMsg altWebConfig(WebConfig webConfig, HttpServletRequest request) {
        return webConfigService.altWebConfig(webConfig, request);
    }
}
