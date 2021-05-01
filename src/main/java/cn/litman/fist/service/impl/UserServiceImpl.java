package cn.litman.fist.service.impl;

import cn.litman.fist.common.ReturnMsg;
import cn.litman.fist.entity.User;
import cn.litman.fist.mapper.UserMapper;
import cn.litman.fist.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Soyung
 * @email tsyon@qq.com
 * @date 2019/4/16 11:32
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper UserMapper;

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
    @Override
    public ReturnMsg signIn(HttpServletRequest request, User User, String code) {
        String uname = adminUser.getUsername();

        Validate.notNull(uname, "请输入用户名");
        Validate.notNull(adminUser.getPassword(), "请填写密码");
        Validate.notNull(code,"请输入验证码");
        String codeSession = request.getSession().getAttribute("code").toString();
        Validate.isTrue(code.equalsIgnoreCase(codeSession),"验证码错误");

        LoginLog loginLog=new LoginLog();
        loginLog.setAccount(uname);
        loginLog.setType((byte)1);
        //获取客户端IP
        String ip = request.getRemoteAddr();
        if(ip != null){
            loginLog.setIp(ip);
            loginLog.setAddress(IpUtil.searchAddr(ip));
        }
        loginLog.setResult((byte)1);
        ReturnMsg returnMsg = new ReturnMsg("用户不存在");
        //验证用户名和密码是否正确
        if(adminUserMapper.findByName(uname) != null){
            adminUser = adminUserMapper.selectByPwd(adminUser);
            if(adminUser != null){
                loginLog.setResult((byte)0);
                returnMsg=ReturnMsg.SUCCESS;
                adminUser.setPassword(null);
                request.getSession().setAttribute(Constant.ADMIN_USER_SESSION, adminUser);
            }else {
                loginLog.setResult((byte)2);
                returnMsg=new ReturnMsg("密码错误");
            }
        }
        loginLogMapper.insertSelective(loginLog);
        return returnMsg;
    }

    /**
     * 后台用户修改密码
     *
     * @param id 用户id
     * @param oldPwd 老密码
     * @param newPwd 新密码
     * @param request 请求
     * @return com.xrdkx.website.common.ReturnMsg
     * @author Soyung
     * @date 2019/4/17 23:40
     */
    @Override
    public ReturnMsg altPwd(Integer id, String oldPwd, String newPwd, HttpServletRequest request) {
        Validate.notNull(id,"id不能为空");
        Validate.notNull(oldPwd,"请输入旧密码");
        Validate.notNull(newPwd,"请输入新密码");
        Validate.isTrue(!oldPwd.equals(newPwd),"新密码和旧密码相同");

        if(adminUserMapper.updatePwd(id,oldPwd,newPwd)){
            request.getSession().removeAttribute(Constant.ADMIN_USER_SESSION);
            return new ReturnMsg(true,ReturnMsg.RESET_SUCCESS);
        }
        return new ReturnMsg("修改失败，请确认原密码是否正确");
    }

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
    @Override
    public PageMsg getAdminUserList(AdminUser adminUser, Integer page, Integer limit) {
        Validate.notNull(page);
        Validate.notNull(limit);
        PageHelper.startPage(page,limit);
        PageInfo listAd = new PageInfo<>(adminUserMapper.listAdminUser(adminUser));
        return new PageMsg(listAd.getTotal(),listAd.getList());
    }

    /**
     * 添加后台用户
     *
     * @param adminUser 后台用户实体类
     * @return com.xrdkx.website.common.ReturnMsg
     * @author Soyung
     * @date 2019/4/26 15:16
     */
    @Override
    public ReturnMsg addAdminUser(AdminUser adminUser) {
        Validate.notNull(adminUser.getUsername(),"请输入用户名");
        Validate.notNull(adminUser.getPassword(),"请输入密码");
        if(adminUserMapper.insertSelective(adminUser)){
            return ReturnMsg.SUCCESS;
        }
        return ReturnMsg.FAIL;
    }

    /**
     * 修改后台用户
     *
     * @param adminUser 后台用户实体类
     * @return com.xrdkx.website.common.ReturnMsg
     * @author Soyung
     * @date 2019/4/26 15:16
     */
    @Override
    public ReturnMsg altAdminUser(AdminUser adminUser) {
        if(adminUserMapper.updateAdminUser(adminUser)){
            return ReturnMsg.SUCCESS;
        }
        return ReturnMsg.FAIL;
    }

    /**
     * 禁用后台用户
     *
     * @param id 后台用户id
     * @param isBan 禁用 0否 1是
     * @return com.xrdkx.website.common.ReturnMsg
     * @author Soyung
     * @date 2019/4/26 15:16
     */
    @Override
    public ReturnMsg banAdminUser(Integer id, Integer isBan) {
        Validate.notNull(id);
        Validate.notNull(isBan);
        if(isBan == 0){
            isBan = 1;
        }else {
            isBan = 0;
        }
        if(adminUserMapper.updateIsBanById(id,isBan)){
            return ReturnMsg.SUCCESS;
        }
        return ReturnMsg.FAIL;
    }
}
