package cn.litman.fist.service;

import com.xrdkx.website.common.PageMsg;
import com.xrdkx.website.common.ReturnMsg;
import com.xrdkx.website.entity.AdminUser;

import javax.servlet.http.HttpServletRequest;

/**
 * 后台用户服务接口
 * @author Soyung
 * @email tsyon@qq.com
 * @date 2019/4/16 17:59
 */
public interface UserService {
    /**
     * 后台登录
     *
     * @param request 请求
     * @param adminUser 用户实体类
     * @param code 验证码
     * @return com.xrdkx.website.common.ReturnMsg
     * @author Soyung
     * @date 2019/4/16 17:56
     */
    ReturnMsg signIn(HttpServletRequest request, AdminUser adminUser, String code);

    /**
     * 后台用户修改密码
     *
     * @param id 用户id
     * @param oldPwd 老密码
     * @param newPwd 新密码
     * @param request 请求
     * @return com.xrdkx.website.common.ReturnMsg
     * @author Soyung
     * @date 2019/4/17 23:29
     */
    ReturnMsg altPwd(Integer id, String oldPwd, String newPwd, HttpServletRequest request);

    /**
     * 获取后台用户列表
     *
     * @param adminUser 后台用户实体类
     * @param page 页码
     * @param limit 每页数据量
     * @return com.xrdkx.website.common.PageMsg
     * @author Soyung
     * @date 2019/4/26 15:16
     */
    PageMsg getAdminUserList(AdminUser adminUser, Integer page, Integer limit);

    /**
     * 添加后台用户
     *
     * @param adminUser 后台用户实体类
     * @return com.xrdkx.website.common.ReturnMsg
     * @author Soyung
     * @date 2019/4/26 15:16
     */
    ReturnMsg addAdminUser(AdminUser adminUser);

    /**
     * 修改后台用户
     *
     * @param adminUser 后台用户实体类
     * @return com.xrdkx.website.common.ReturnMsg
     * @author Soyung
     * @date 2019/4/26 15:16
     */
    ReturnMsg altAdminUser(AdminUser adminUser);

    /**
     * 禁用后台用户
     *
     * @param id 后台用户id
     * @param isBan 禁用 0否 1是
     * @return com.xrdkx.website.common.ReturnMsg
     * @author Soyung
     * @date 2019/4/26 15:16
     */
    ReturnMsg banAdminUser(Integer id,Integer isBan);
}
