package cn.litman.fist.common;

import lombok.Getter;
import lombok.Setter;

/**
 * 返回信息模板类
 * @author SoyungTong
 * @email litman@126.com
 * @date 2021/5/1 16:11
 */
@Getter
@Setter
public class ReturnMsg {

    /**
    *返回结果，失败：false，成功：true
    */
    private Boolean rs;

    /**
     *返回话术
     */
    private String info;

    /**
     *返回数据
     */
    private Object data;

    public static final String SUCCESS_INFO="请求成功";
    public static final String FAIL_INFO="请求失败";

    public static final String RESET_SUCCESS = "密码修改成功，请登录";

    public static final ReturnMsg SUCCESS = new ReturnMsg(true, SUCCESS_INFO);
    public static final ReturnMsg FAIL = new ReturnMsg(FAIL_INFO);

    public ReturnMsg(String info){
        this.rs = false;
        this.info = info;
    }
    public ReturnMsg(Boolean rs, String info){
        this.rs = rs;
        this.info = info;
    }
    public ReturnMsg(Boolean rs, String info, Object data){
        this.rs = rs;
        this.info = info;
        this.data=data;
    }

}
