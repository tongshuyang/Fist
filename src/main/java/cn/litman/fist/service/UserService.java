package cn.litman.fist.service;

import cn.litman.fist.common.PageMsg;
import cn.litman.fist.common.ReturnMsg;
import cn.litman.fist.entity.User;
import javax.servlet.http.HttpServletRequest;

/**
 * 用户服务接口类
 * @author SoyungTong
 * @email litman@126.com
 * @date 2021/5/2 13:11
 */
public interface UserService {

    /**
     * 后台登录
     *
     * @param request 请求
     * @param user 用户实体类
     * @param code 验证码
     * @return cn.litman.fist.common.ReturnMsg
     * @author SoyungTong
     * @date 2021/5/2 13:11
     */
    ReturnMsg signIn(HttpServletRequest request, User user, String code);

    /**
     * 后台用户修改密码
     *
     * @param id 用户id
     * @param oldPwd 老密码
     * @param newPwd 新密码
     * @param request 请求
     * @return cn.litman.fist.common.ReturnMsg
     * @author SoyungTong
     * @date 2021/5/2 14:22
     */
    ReturnMsg altPwd(Integer id, String oldPwd, String newPwd, HttpServletRequest request);

    /**
     * 获取用户列表
     *
     * @param user 后台用户实体类
     * @param page 页码
     * @param limit 每页数据量
     * @return cn.litman.fist.common.PageMsg
     * @author SoyungTong
     * @date 2021/5/2 14:22
     */
    PageMsg listUser(User user, Integer page, Integer limit);

    /**
     * 添加用户
     *
     * @param user 后台用户实体类
     * @return cn.litman.fist.common.ReturnMsg
     * @author SoyungTong
     * @date 2021/5/2 14:22
     */
    ReturnMsg addUser(User user);

    /**
     * 修改用户
     *
     * @param user 用户实体类
     * @return cn.litman.fist.common.ReturnMsg
     * @author SoyungTong
     * @date 2021/5/2 14:42
     */
    ReturnMsg altUser(User user);

    /**
     * 禁用用户
     *
     * @param id 后台用户id
     * @param isBan 禁用 0否 1是
     * @return cn.litman.fist.common.ReturnMsg
     * @author SoyungTong
     * @date 2021/5/2 14:48
     */
    ReturnMsg banUser(Integer id,Integer isBan);
}
