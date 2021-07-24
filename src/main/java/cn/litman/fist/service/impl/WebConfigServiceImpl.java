package cn.litman.fist.service.impl;

import cn.litman.fist.common.Constant;
import cn.litman.fist.common.PageMsg;
import cn.litman.fist.common.ReturnMsg;
import cn.litman.fist.entity.AliOSSConf;
import cn.litman.fist.entity.WebConfig;
import cn.litman.fist.mapper.WebConfigMapper;
import cn.litman.fist.service.WebConfigService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Override
    public AliOSSConf getAliConf() {
        //查询OSS配置，放入集合，方便查询使用
        Map<String,String> conf = new HashMap<>(20);
        List<WebConfig> webConfigs = webConfigMapper.listPubConf();
        for (WebConfig webConfig:webConfigs
        ) {
            conf.put(webConfig.getKey(),webConfig.getValue());
        }

        //从集合中获取对应值赋值给AliOSSConf
        AliOSSConf aliConf = new AliOSSConf();
        aliConf.setEndpoint(conf.get("endpoint"));
        aliConf.setAccessKeyId(conf.get("accessKeyId"));
        aliConf.setAccessKeySecret(conf.get("accessKeySecret"));
        aliConf.setBucketName(conf.get("bucketName"));
        aliConf.setMaxUpload(Integer.parseInt(conf.get("maxUpload")) * 1024 * 1024);

        return  aliConf;
    }
}