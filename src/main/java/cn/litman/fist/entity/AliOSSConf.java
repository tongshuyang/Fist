package cn.litman.fist.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * 阿里OSS配置实体类
 * @author SoyungTong
 * @email litman@126.com
 * @date 2021/7/24 17:06
 */
@Getter
@Setter
public class AliOSSConf {

    /**
     * 请求根目录
     */
    private String endpoint;

    /**
     * 应用ID
     */
    private String accessKeyId;

    /**
     * 应用密钥
     */
    private String accessKeySecret;

    /**
     * 存储桶名称
     */
    private String bucketName;

    /**
     * 最大文件上传限制
     */
    private int maxUpload;
}
