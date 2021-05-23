package cn.litman.fist.util;

import cn.litman.fist.entity.WebConfig;
import cn.litman.fist.mapper.WebConfigMapper;
import com.aliyun.oss.ClientBuilderConfiguration;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.sun.istack.internal.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * @author SoyungTong
 * @email litman@126.com
 * @date 2021/5/3 16:23
 */
public class AliOSS {
    @Autowired
    private WebConfigMapper webConfigMapper;

    private static final Map<String,String> CONF = new HashMap<>(20);

    private static String endpoint = "";
    private static String accessKeyId = "";
    private static String accessKeySecret = "";
    private static String bucketName = "";
    private static int maxUpload = 10 * 1024 * 1024;

    {
        List<WebConfig> webConfigs = webConfigMapper.listConf(new WebConfig());
        for (WebConfig webConfig:webConfigs
        ) {
            CONF.put(webConfig.getKey(),webConfig.getValue());
        }
        endpoint = CONF.get("endpoint");
        accessKeyId = CONF.get("accessKeyId");
        accessKeySecret = CONF.get("accessKeySecret");
        bucketName = CONF.get("bucketName");
        maxUpload = Integer.parseInt(CONF.get("maxUpload")) * 1024 * 1024;
    }
//    private static final String ENDPOINT = conf.get("endpoint");
//    private static final String ACCESS_KEY_ID = conf.get("accessKeyId");
//    private static final String ACCESS_KEY_SECRET = conf.get("accessKeySecret");
//    private static final String BUCKET_NAME = conf.get("bucketName");
//    private static final String KEY = "";
//    private static final Integer MAX_UPLOAD = 5 * 1024 * 1024;

    /**
     * 阿里云上传文件
     *
     * @param file 上传的文件流
     * @param path 文件上传路径
     * @return java.lang.String
     * @author SoyungTong
     * @date 2021/5/20 0:38
     */
    public static String fileUpload(@NotNull MultipartFile file, String path) throws Exception {
        //判断文件大小是否超出上传限制
        if (file.getSize() > maxUpload) {
            throw new Exception("上传文件大小不能超过" + CONF.get("maxUpload") + "MB！");
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
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret, conf);

        //上传文件到OSS
        ossClient.putObject(bucketName, objectName, file.getInputStream());

        // 关闭OSSClient。
        ossClient.shutdown();

        return objectName;
    }
}
