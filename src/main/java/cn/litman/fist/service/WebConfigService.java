package cn.litman.fist.service;

import cn.litman.fist.common.PageMsg;
import cn.litman.fist.common.ReturnMsg;
import cn.litman.fist.entity.AliOSSConf;
import cn.litman.fist.entity.WebConfig;
import org.springframework.stereotype.Service;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 网站配置类服务接口
 * @author SoyungTong
 * @email litman@126.com
 * @date 2021/5/2 17:02
 */
public interface WebConfigService {

    /**
     * 获取网站配置列表
     *
     * @param webConfig 网站配置实体类
     * @param page 页码
     * @param limit 每页数据量
     * @return cn.litman.fist.common.PageMsg
     * @author SoyungTong
     * @date 2021/5/2 16:58
     */
    PageMsg listConf(WebConfig webConfig, Integer page, Integer limit);

    /**
     * 修改网站配置
     *
     * @param webConfig 网站配置实体类
     * @param request 请求
     * @return cn.litman.fist.common.ReturnMsg
     * @author SoyungTong
     * @date 2021/5/2 17:02
     */
    ReturnMsg altConf(WebConfig webConfig, HttpServletRequest request);

    /**
     * 获取阿里OSS配置
     *
     * @return cn.litman.fist.entity.AliOSSConf
     * @author SoyungTong
     * @date 2021/7/24 17:13
     */
    AliOSSConf getAliConf();
}
