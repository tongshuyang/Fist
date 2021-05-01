package cn.litman.fist.controller;

import cn.litman.fist.common.ReturnMsg;
import cn.litman.fist.entity.User;
import cn.litman.fist.service.UserService;
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
@RequestMapping("/admin_user")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 登录页面
     *
     * @return java.lang.String
     * @author Soyung
     * @date 2019/4/16 17:47
     */
    @GetMapping("/sign_in")
    public String signInView(){
        return "rms/sign_in";
    }

    /**
     * 登录
     *
     * @param request 请求
     * @param user 用户实体类
     * @param code 验证码
     * @return com.xrdkx.website.common.ReturnMsg
     * @author Soyung
     * @date 2019/4/16 18:01
     */
    @ResponseBody
    @PostMapping("/sign_in_do")
    public ReturnMsg signIn(HttpServletRequest request, User user, String code){
        return userService.signIn(request, user,code);
    }

    /**
     * 获取图片验证码
     *
     * @param request 请求
     * @param response 回复
     * @return java.lang.String
     * @author Soyung
     * @date 2019/4/16 17:46
     */
    @GetMapping("/get_verify_code")
    public String validateCode(HttpServletRequest request, HttpServletResponse response) throws Exception{
        // 设置响应的类型格式为图片格式
        response.setContentType("image/jpeg");
        //禁止图像缓存。
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);

        VerifyCode vCode = new VerifyCode(120,36,4,100);
        request.getSession().setAttribute("code", vCode.getCode());
        vCode.write(response.getOutputStream());
        return null;
    }

    /**
     * 退出登录
     *
     * @param request 请求
     * @return java.lang.String
     * @author Soyung
     * @date 2019/4/17 15:35
     */
    @ResponseBody
    @GetMapping("/sign_out")
    public ReturnMsg signOut(HttpServletRequest request){
        request.getSession().removeAttribute(Constant.ADMIN_USER_SESSION);
        return new ReturnMsg(true,"退出成功","/admin_user/sign_in");
    }

    /**
     * 修改密码界面
     *
     * @return java.lang.String
     * @author Soyung
     * @date 2019/4/18 0:01
     */
    @GetMapping("/rms/alt_pwd_view")
    public String altPwdView(){
        return "rms/alt_pwd";
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
     * @date 2019/4/17 23:39
     */
    @ResponseBody
    @PostMapping("/rms/alt_pwd")
    public ReturnMsg altPwd(Integer id, String oldPwd,String newPwd, HttpServletRequest request){
        return adminUserService.altPwd(id, oldPwd, newPwd, request);
    }

    /**
     * 后台用户管理视图
     *
     * @return java.lang.String
     * @author Soyung
     * @date 2019/4/26 13:29
     */
    @GetMapping("/rms/admin_user_manage")
    public String adminUserManage(){
        return "rms/admin_user_manage";
    }

    /**
     * 后台用户修改视图
     *
     * @return java.lang.String
     * @author Soyung
     * @date 2019/4/26 13:29
     */
    @GetMapping("/rms/edit_admin_user_dialog")
    public String editAdminUserDialog(){
        return "/rms/dialog/edit_admin_user";
    }

    /**
     * 获取后台用户列表
     *
     * @param adminUser 后台用户实体类
     * @param page 页码
     * @param limit 每页数据量
     * @return com.xrdkx.website.common.PageMsg
     * @author Soyung
     * @date 2019/4/26 8:58
     */
    @ResponseBody
    @GetMapping("/rms/list_admin_user")
    public PageMsg getAdminUserList(AdminUser adminUser, Integer page, Integer limit){
        return adminUserService.getAdminUserList(adminUser,page,limit);
    }

    /**
     * 添加后台用户
     *
     * @param adminUser 后台用户实体类
     * @return com.xrdkx.website.common.ReturnMsg
     * @author Soyung
     * @date 2019/4/26 11:48
     */
    @ResponseBody
    @PostMapping("/rms/add_admin_user")
    public ReturnMsg addAdminUser(AdminUser adminUser) {
        return adminUserService.addAdminUser(adminUser);
    }

    /**
     * 修改后台用户
     *
     * @param adminUser 后台用户实体类
     * @return com.xrdkx.website.common.ReturnMsg
     * @author Soyung
     * @date 2019/4/26 11:48
     */
    @ResponseBody
    @PostMapping("/rms/alt_admin_user")
    public ReturnMsg altAdminUser(AdminUser adminUser) {
        return adminUserService.altAdminUser(adminUser);
    }

    /**
     * 禁用后台用户
     *
     * @param id 后台用户id
     * @param isBan 禁用 0否 1是
     * @return com.xrdkx.website.common.ReturnMsg
     * @author Soyung
     * @date 2019/4/26 9:01
     */
    @ResponseBody
    @GetMapping("/rms/ban_admin_user")
    public ReturnMsg banAdminUser(Integer id, Integer isBan){
        return adminUserService.banAdminUser(id, isBan);
    }
}
