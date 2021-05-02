package cn.litman.fist.mapper;

import cn.litman.fist.entity.WebConfig;
import java.util.List;

/**
 * 网站配置映射接口
 * @author Soyung
 * @email tsyon@qq.com
 * @date 2019/3/23 17:04
 */
public interface WebConfigMapper {

    int insertSelective(WebConfig record);

    /**
     * 查询网站配置列表
     *
     * @param webConfig 网站配置实体类
     * @return java.util.List<com.xrdkx.website.entity.WebConfig>
     * @author Soyung
     * @date 2019/3/29 18:48
     */
    List<WebConfig> listWebConfig(WebConfig webConfig);

    /**
     * 修改网站配置
     *
     * @param webConfig 网站配置实体类
     * @return java.lang.Boolean
     * @author Soyung
     * @date 2019/4/26 17:40
     */
    Boolean updateWebConfig(WebConfig webConfig);
}