package cn.litman.fist.controller;

import cn.litman.fist.common.Constant;
import cn.litman.fist.common.PageMsg;
import cn.litman.fist.common.ReturnMsg;
import cn.litman.fist.entity.User;
import cn.litman.fist.service.UserService;
import cn.litman.fist.util.VerifyCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author SoyungTong
 * @email litman@126.com
 * @date 2021/5/2 1:39
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 用户登录验证
     *
     * @param request 请求
     * @param user 用户实体类
     * @param code 验证码
     * @return cn.litman.fist.common.ReturnMsg
     * @author SoyungTong
     * @date 2021/5/2 13:07
     */
    @ResponseBody
    @PostMapping("/sign_in")
    public ReturnMsg signIn(HttpServletRequest request, User user, String code){
        return userService.signIn(request, user, code);
    }

    /**
     * 获取图片验证码
     *
     * @param request 请求
     * @param response 回复
     * @return java.lang.String
     * @author SoyungTong
     * @date 2021/5/2 13:07
     */
    @GetMapping("/get_verify_code")
    public String getVerifyCode(HttpServletRequest request, HttpServletResponse response) throws Exception{
        // 设置响应的类型格式为图片
        response.setContentType("image/jpeg");
        //禁止图像缓存
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        //生成验证码
        VerifyCode verifyCode = new VerifyCode(120,36,4,100);
        //放入session，后续验证使用
        request.getSession().setAttribute(Constant.CODE_SESSION, verifyCode.getCode());
        //验证码图片返回给前端界面
        verifyCode.write(response.getOutputStream());
        return null;
    }

    /**
     * 退出登录
     *
     * @param request 请求
     * @return java.lang.String
     * @author SoyungTong
     * @date 2021/5/2 13:55
     */
    @ResponseBody
    @GetMapping("/sign_out")
    public ReturnMsg signOut(HttpServletRequest request){
        request.getSession().removeAttribute(Constant.USER_SESSION);
        return new ReturnMsg(true,"退出成功","/");
    }

    /**
     * 跳转修改密码界面
     *
     * @return java.lang.String
     * @author SoyungTong
     * @date 2021/5/2 13:55
     */
    @GetMapping("/alt_pwd_view/verify")
    public String altPwdView(){
        return "alt_pwd";
    }

    /**
     * 用户修改密码操作
     *
     * @param id 用户ID
     * @param oldPwd 旧密码
     * @param newPwd 新密码
     * @param request 请求
     * @return cn.litman.fist.common.ReturnMsg
     * @author SoyungTong
     * @date 2021/5/2 14:06
     */
    @ResponseBody
    @PostMapping("/alt_pwd/verify")
    public ReturnMsg altPwd(Integer id, String oldPwd,String newPwd, HttpServletRequest request){
        return userService.altPwd(id, oldPwd, newPwd, request);
    }

    /**
     * 用户管理界面
     *
     * @return java.lang.String
     * @author SoyungTong
     * @date 2021/5/2 14:06
     */
    @GetMapping("/user_manage_view/verify")
    public String userManageView(){
        return "user_manage";
    }

    /**
     * 用户修改弹窗
     *
     * @return java.lang.String
     * @author SoyungTong
     * @date 2021/5/2 14:06
     */
    @GetMapping("/edit_user_dialog/verify")
    public String editUserDialog(){
        return "/modal/edit_user";
    }

    /**
     * 获取用户列表
     *
     * @param user 用户实体类
     * @param page 页码
     * @param limit 每页数据量
     * @return cn.litman.fist.common.PageMsg
     * @author SoyungTong
     * @date 2021/5/2 14:06
     */
    @ResponseBody
    @GetMapping("/list_user/verify")
    public PageMsg listUser(User user, Integer page, Integer limit){
        return userService.listUser(user, page, limit);
    }

    /**
     * 添加用户
     *
     * @param user 用户实体类
     * @return cn.litman.fist.common.ReturnMsg
     * @author SoyungTong
     * @date 2021/5/2 14:38
     */
    @ResponseBody
    @PostMapping("/add_user/verify")
    public ReturnMsg addUser(User user) {
        return userService.addUser(user);
    }

    /**
     * 修改用户信息
     *
     * @param user 用户实体类
     * @return cn.litman.fist.common.ReturnMsg
     * @author SoyungTong
     * @date 2021/5/2 14:40
     */
    @ResponseBody
    @PostMapping("/alt_user/verify")
    public ReturnMsg altUser(User user) {
        return userService.altUser(user);
    }

    /**
     * 禁用用户
     *
     * @param id 用户id
     * @param isBan 禁用 0否 1是
     * @return cn.litman.fist.common.ReturnMsg
     * @author SoyungTong
     * @date 2021/5/2 14:48
     */
    @ResponseBody
    @GetMapping("/ban_user/verify")
    public ReturnMsg banUser(Integer id, Integer isBan){
        return userService.banUser(id, isBan);
    }
}
