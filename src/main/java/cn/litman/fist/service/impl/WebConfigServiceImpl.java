package cn.litman.fist.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xrdkx.website.common.Constant;
import com.xrdkx.website.common.PageMsg;
import com.xrdkx.website.common.ReturnMsg;
import com.xrdkx.website.entity.WebConfig;
import com.xrdkx.website.mapper.WebConfigMapper;
import com.xrdkx.website.service.WebConfigService;
import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author Soyung
 * @email tsyon@qq.com
 * @date 2019/3/27 13:18
 */
@Service
public class WebConfigServiceImpl implements WebConfigService {
    @Autowired
    private WebConfigMapper webConfigMapper;

    /**
     * 查询网站配置列表
     *
     * @return java.util.List<com.xrdkx.website.entity.WebConfig>
     * @author Soyung
     * @date 2019/3/29 18:48
     */
    @Override
    public List<WebConfig> listWebConfig() {
        return webConfigMapper.listWebConfig(null);
    }

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
    @Override
    public PageMsg getWebConfigList(WebConfig webConfig, Integer page, Integer limit) {
        Validate.notNull(page);
        Validate.notNull(limit);
        PageHelper.startPage(page,limit);
        PageInfo listAd = new PageInfo<>(webConfigMapper.listWebConfig(webConfig));
        return new PageMsg(listAd.getTotal(),listAd.getList());
    }

    /**
     * 修改网站配置
     *
     * @param webConfig 网站配置实体类
     * @param request 请求
     * @return com.xrdkx.website.common.ReturnMsg
     * @author Soyung
     * @date 2019/4/26 17:35
     */
    @Override
    public ReturnMsg altWebConfig(WebConfig webConfig, HttpServletRequest request) {
        if(webConfigMapper.updateWebConfig(webConfig)){
            request.getServletContext().removeAttribute(Constant.CONF_SESSION);
            return ReturnMsg.SUCCESS;
        }
        return ReturnMsg.FAIL;
    }
}