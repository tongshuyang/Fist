package cn.litman.fist.service;

import cn.litman.fist.common.PageMsg;
import cn.litman.fist.common.ReturnMsg;
import cn.litman.fist.entity.WebConfig;
import org.springframework.stereotype.Service;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 网站配置类服务接口
 * @author Soyung
 * @email tsyon@qq.com
 * @date 2019/3/29 17:50
 */
@Service
public interface WebConfigService {
    /**
     * 查询网站配置列表
     *
     * @return java.util.List<com.xrdkx.website.entity.WebConfig>
     * @author Soyung
     * @date 2019/3/29 18:48
     */
    List<WebConfig> listWebConfig();

    /**
     * 获取网站配置列表
     *
     * @param webConfig 网站配置实体类
     * @param page 页码
     * @param limit 每页数据量
     * @return com.xrdkx.website.common.PageMsg
     * @author Soyung
     * @date 2019/4/26 17:34
     */
    PageMsg getWebConfigList(WebConfig webConfig, Integer page, Integer limit);

    /**
     * 修改网站配置
     *
     * @param webConfig 网站配置实体类
     * @param request 请求
     * @return com.xrdkx.website.common.ReturnMsg
     * @author Soyung
     * @date 2019/4/26 17:35
     */
    ReturnMsg altWebConfig(WebConfig webConfig, HttpServletRequest request);
}
