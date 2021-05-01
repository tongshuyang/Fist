package cn.litman.fist.common;

import lombok.Getter;
import lombok.Setter;

/**
 * 分页信息模板类
 * @author SoyungTong
 * @email litman@126.com
 * @date 2021/5/1 16:11
 */
@Getter
@Setter
public class PageMsg {

    /**
    *返回码
    */
    private Integer code;

    /**
     *返回信息
     */
    private String msg;

    /**
     *返回的数据条数
     */
    private Long count;

    /**
     *返回分页数据
     */
    private Object data;

    public PageMsg(Long count, Object data) {
        this.code = 0;
        this.msg = "";
        this.count = count;
        this.data = data;
    }

    public PageMsg(String msg, Long count, Object data) {
        this.code = 0;
        this.msg = msg;
        this.count = count;
        this.data = data;
    }

    public PageMsg(Integer code, String msg, Long count, Object data) {
        this.code = code;
        this.msg = msg;
        this.count = count;
        this.data = data;
    }
}
