package cn.litman.fist.common;

/**
 * 全局常量接口
 * @author SoyungTong
 * @email litman@126.com
 * @date 2021/5/1 16:11
 */
public interface Constant {
    /**
     * 用户信息的session键
     */
    String USER_SESSION = "user";

    /**
     * 网站配置信息的session键
     */
    String CONF_SESSION = "conf";

    /**
     * 验证码session键
     */
    String CODE_SESSION = "code";

    /**
     * 本站网址
     */
    String DOMAIN = "http://127.0.0.1/";

    /**
     * 图片上传路径
     */
    String IMG_UPLOAD_PATH = "/img/";

}
