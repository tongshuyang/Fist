package cn.litman.fist.service.impl;

import cn.litman.fist.common.Constant;
import cn.litman.fist.common.PageMsg;
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
 * 用户服务实现类
 * @author SoyungTong
 * @email litman@126.com
 * @date 2021/5/2 13:13
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public ReturnMsg signIn(HttpServletRequest request, User user, String code) {
        //验证参数填写是否正确
        String userName = user.getUsername();
        Validate.notNull(userName, "请输入用户名");
        Validate.notNull(user.getPassword(), "请填写密码");
        Validate.notNull(code,"请输入验证码");
        String codeSession = request.getSession().getAttribute("code").toString();
        Validate.isTrue(code.equalsIgnoreCase(codeSession),"验证码错误");
        //验证用户是否存在，用户名和密码是否正确
        ReturnMsg returnMsg = new ReturnMsg("用户不存在");
        if(userMapper.findByUserName(userName) != null){
            user = userMapper.verifyUser(user);
            if(user != null){
                returnMsg=ReturnMsg.SUCCESS;
                user.setPassword(null);
                //用户信息放入session中
                request.getSession().setAttribute(Constant.USER_SESSION, user);
            }else {
                returnMsg=new ReturnMsg("密码错误");
            }
        }
        return returnMsg;
    }

    @Override
    public ReturnMsg altPwd(Integer id, String oldPwd, String newPwd, HttpServletRequest request) {
        //参数验证
        Validate.notNull(id,"id不能为空");
        Validate.notNull(oldPwd,"请输入旧密码");
        Validate.notNull(newPwd,"请输入新密码");
        Validate.isTrue(!oldPwd.equals(newPwd),"新密码和旧密码相同");
        //修改密码
        if(userMapper.updatePwd(id,oldPwd,newPwd)){
            request.getSession().removeAttribute(Constant.USER_SESSION);
            return new ReturnMsg(true,ReturnMsg.RESET_SUCCESS);
        }
        return new ReturnMsg("密码修改失败，请确认原密码是否正确");
    }

    @Override
    public PageMsg listUser(User user, Integer page, Integer limit) {
        //参数验证
        Validate.notNull(page);
        Validate.notNull(limit);
        //分页并返回结果
        PageHelper.startPage(page,limit);
        PageInfo<User> listUser = new PageInfo<>(userMapper.listUser(user));
        return new PageMsg(listUser.getTotal(),listUser.getList());
    }

    @Override
    public ReturnMsg addUser(User user) {
        //参数验证
        Validate.notNull(user.getUsername(),"请输入用户名");
        Validate.notNull(user.getPassword(),"请输入密码");
        //添加用户信息
        if(userMapper.insertUser(user)){
            return ReturnMsg.SUCCESS;
        }
        return ReturnMsg.FAIL;
    }

    @Override
    public ReturnMsg altUser(User user) {
        if(userMapper.updateUser(user)){
            return ReturnMsg.SUCCESS;
        }
        return ReturnMsg.FAIL;
    }

    @Override
    public ReturnMsg banUser(Integer id, Integer isBan) {
        //参数验证
        Validate.notNull(id);
        Validate.notNull(isBan);
        //修改禁用状态
        if(isBan == 0){
            isBan = 1;
        }else {
            isBan = 0;
        }
        //禁用用户
        if(userMapper.banUserById(id,isBan)){
            return ReturnMsg.SUCCESS;
        }
        return ReturnMsg.FAIL;
    }
}
