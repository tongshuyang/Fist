package cn.litman.fist.mapper;

import com.xrdkx.website.entity.AdminUser;

import java.util.List;

/**
 * 管理员信息映射接口
 * @author Soyung
 * @email tsyon@qq.com
 * @date 2019/3/23 10:10
 */
public interface UserMapper {

    /**
     * 添加后台用户
     *
     * @param adminUser 后台用户实体类
     * @return Boolean
     * @author Soyung
     * @date 2019/4/16 22:35
     */
    Boolean insertSelective(AdminUser adminUser);

    /**
     * 查询用户是否存在
     *
     * @param uname 用户名
     * @return String
     * @author Soyung
     * @date 2019/4/16 22:04
     */
    String findByName(String uname);

    /**
     * 后台用户登录
     *
     * @param adminUser 后台用户实体类
     * @return com.xrdkx.website.entity.AdminUser
     * @author Soyung
     * @date 2019/4/16 22:13
     */
    AdminUser selectByPwd(AdminUser adminUser);

    /**
     * 后台用户修改密码
     *
     * @param id 用户id
     * @param oldPwd 老密码
     * @param newPwd 新密码
     * @return boolean
     * @author Soyung
     * @date 2019/4/17 23:43
     */
    boolean updatePwd(Integer id, String oldPwd, String newPwd);

    /**
     * 获取后台用户列表
     *
     * @param adminUser 后台用户实体类
     * @return java.util.List<com.xrdkx.website.entity.AdminUser>
     * @author Soyung
     * @date 2019/4/26 15:41
     */
    List<AdminUser> listAdminUser(AdminUser adminUser);

    /**
     * 修改后台用户
     *
     * @param adminUser 后台用户实体类
     * @return java.lang.Boolean
     * @author Soyung
     * @date 2019/4/26 15:42
     */
    Boolean updateAdminUser(AdminUser adminUser);

    /**
     * 禁用后台用户
     *
     * @param id 后台用户id
     * @param isBan 禁止
     * @return java.lang.Boolean
     * @author Soyung
     * @date 2019/4/26 15:43
     */
    Boolean updateIsBanById(Integer id, Integer isBan);
}