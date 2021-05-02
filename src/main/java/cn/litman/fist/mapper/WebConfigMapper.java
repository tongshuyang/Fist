package cn.litman.fist.mapper;

import cn.litman.fist.entity.WebConfig;
import java.util.List;

/**
 * 网站配置映射接口
 * @author SoyungTong
 * @email litman@126.com
 * @date 2021/5/2 17:07
 */
public interface WebConfigMapper {

    /**
     * 查询网站配置列表
     *
     * @param webConfig 网站配置实体类
     * @return java.util.List<cn.litman.fist.entity.WebConfig>
     * @author SoyungTong
     * @date 2021/5/2 17:06
     */
    List<WebConfig> listConf(WebConfig webConfig);

    /**
     * 修改网站配置
     *
     * @param webConfig 网站配置实体类
     * @return java.lang.Boolean
     * @author SoyungTong
     * @date 2021/5/2 17:06
     */
    Boolean updateWebConfig(WebConfig webConfig);
}