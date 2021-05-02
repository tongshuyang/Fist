package cn.litman.fist.mapper;

import cn.litman.fist.entity.User;
import java.util.List;

/**
 * 管理员信息映射接口
 * @author SoyungTong
 * @email litman@126.com
 * @date 2021/5/2 13:17
 */
public interface UserMapper {

    /**
     * 添加用户
     *
     * @param user 用户实体类
     * @return Boolean
     * @author SoyungTong
     * @date 2021/5/2 13:17
     */
    Boolean insertUser(User user);

    /**
     * 查询用户是否存在
     *
     * @param userName 用户名
     * @return String
     * @author SoyungTong
     * @date 2021/5/2 13:17
     */
    String findByUserName(String userName);

    /**
     * 用户登录验证
     *
     * @param user 用户实体类
     * @return cn.litman.fist.entity.AdminUser
     * @author SoyungTong
     * @date 2021/5/2 13:17
     */
    User verifyUser(User user);

    /**
     * 用户修改密码
     *
     * @param id 用户id
     * @param oldPwd 老密码
     * @param newPwd 新密码
     * @return java.lang.Boolean
     * @author SoyungTong
     * @date 2021/5/2 13:17
     */
    Boolean updatePwd(Integer id, String oldPwd, String newPwd);

    /**
     * 获取用户列表
     *
     * @param user 用户实体类
     * @return java.util.List<cn.litman.fist.entity.User>
     * @author SoyungTong
     * @date 2021/5/2 15:04
     */
    List<User> listUser(User user);

    /**
     * 修改用户信息
     *
     * @param user 用户实体类
     * @return java.lang.Boolean
     * @author SoyungTong
     * @date 2021/5/2 14:43
     */
    Boolean updateUser(User user);

    /**
     * 禁用用户
     *
     * @param id 用户id
     * @param isBan 禁止
     * @return java.lang.Boolean
     * @author SoyungTong
     * @date 2021/5/2 15:04
     */
    Boolean banUserById(Integer id, Integer isBan);
}