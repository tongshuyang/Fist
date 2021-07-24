package cn.litman.fist.util;

import cn.litman.fist.entity.AliOSSConf;
import cn.litman.fist.service.WebConfigService;
import cn.litman.fist.service.impl.WebConfigServiceImpl;
import com.aliyun.oss.ClientBuilderConfiguration;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.sun.istack.internal.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import java.util.Random;

/**
 * @author SoyungTong
 * @email litman@126.com
 * @date 2021/5/3 16:23
 */
@Service
public class AliOSS implements AliOSSService{
    @Autowired
    private WebConfigService webConfigService;
    /**
     * 阿里云上传文件
     *
     * @param file 上传的文件流
     * @param path 文件上传路径
     * @return java.lang.String
     * @author SoyungTong
     * @date 2021/5/20 0:38
     */
    @Override
    public String fileUpload(@NotNull MultipartFile file, String path) throws Exception {
        AliOSSConf aliConf = webConfigService.getAliConf();
        //判断文件大小是否超出上传限制
        if (file.getSize() > aliConf.getMaxUpload()) {
            throw new Exception("上传文件大小不能超过" + aliConf.getMaxUpload() + "MB！");
        }
        //获取文件名
        String originalFilename = file.getOriginalFilename();
        String substr=".png";
        if(originalFilename != null){
            substr = originalFilename.substring(originalFilename.lastIndexOf(".")).toLowerCase();
        }
        Random random = new Random();
        //拼接存储文件名=五位随机数+当前时间戳+文件后缀名
        String fileName = random.nextInt(10000) + System.currentTimeMillis() + substr;
        //上传到 OSS 上的对象键，保存路径
        String objectName = path + fileName;

        // 创建ClientConfiguration实例，您可以按照实际情况修改默认参数。
        ClientBuilderConfiguration conf = new ClientBuilderConfiguration();
        // 设置是否支持CNAME。CNAME用于将自定义域名绑定到目标Bucket。
        conf.setSupportCname(true);

        //生成 cos 客户端
        OSS ossClient = new OSSClientBuilder().build(aliConf.getEndpoint(), aliConf.getAccessKeyId(), aliConf.getAccessKeySecret(), conf);

        //上传文件到OSS
        ossClient.putObject(aliConf.getBucketName(), objectName, file.getInputStream());

        // 关闭OSSClient。
        ossClient.shutdown();

        return objectName;
    }
}
