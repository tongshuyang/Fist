package cn.litman.fist.service.impl;

import cn.litman.fist.common.Constant;
import cn.litman.fist.common.PageMsg;
import cn.litman.fist.common.ReturnMsg;
import cn.litman.fist.entity.WebConfig;
import cn.litman.fist.mapper.WebConfigMapper;
import cn.litman.fist.service.WebConfigService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 网站配置服务实现类
 * @author SoyungTong
 * @email litman@126.com
 * @date 2021/5/2 17:03
 */
@Service
public class WebConfigServiceImpl implements WebConfigService {
    @Autowired
    private WebConfigMapper webConfigMapper;

    @Override
    public PageMsg listConf(WebConfig webConfig, Integer page, Integer limit) {
        Validate.notNull(page);
        Validate.notNull(limit);
        PageHelper.startPage(page,limit);
        PageInfo<WebConfig> webConfigList = new PageInfo<>(webConfigMapper.listConf(webConfig));
        return new PageMsg(webConfigList.getTotal(),webConfigList.getList());
    }

    @Override
    public ReturnMsg altConf(WebConfig webConfig, HttpServletRequest request) {
        if(webConfigMapper.updateWebConfig(webConfig)){
            request.getServletContext().removeAttribute(Constant.CONF_SESSION);
            return ReturnMsg.SUCCESS;
        }
        return ReturnMsg.FAIL;
    }
}