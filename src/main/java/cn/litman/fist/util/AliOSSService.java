package cn.litman.fist.util;

import com.sun.istack.internal.NotNull;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author SoyungTong
 * @email litman@126.com
 * @date 2021/7/24 18:39
 */
public interface AliOSSService {
    /**
     * 阿里云上传文件
     *
     * @param file 上传的文件流
     * @param path 文件上传路径
     * @return java.lang.String
     * @author SoyungTong
     * @date 2021/5/20 0:38
     */
    String fileUpload(@NotNull MultipartFile file, String path) throws Exception;
}
