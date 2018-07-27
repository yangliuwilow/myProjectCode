package com.willow.web.core;

import com.willow.common.util.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;


/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Time: 下午5:15
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("/login")
public class LoginController   extends BaseController {
    /**
     *
     * @param request
     * @TODO     HttpServletRequest request  ，Model对象为null
     *  问题描述： srping 由<spring.version>3.2.4.RELEASE</spring.version>-->
     *             更改为4.3 版本后， HttpServletRequest request  ，Model对象为null,
     *  解决方案： 修改servlet版本为3.0和把tomcat6插件改为tomcat7 问题解决
     * @return
     */
    @RequestMapping
    public String login(HttpServletRequest request){
        String userName=request.getParameter("userName");
        if(StringUtils.isNotEmpty(userName)){
            return "index";
           // return  redirectOuter("/user");
        }
        return "/user/login";
    }

    /**
     * 显示列表
     */
    @RequestMapping(value="/doLogin")
    public String doLogin(){
       return  redirectOuter("/user");
    }
    /**
     * 显示列表
     */
    @RequestMapping(value = "index")
    public String index(){
        return "index";
    }
   /* @Autowired
    private AuthUserBusiness authUserService;
    @Autowired
    private AuthRoleBusiness authRoleService;
    @Autowired
    private AuthFuncBusiness authFuncService;

    *//**
     * 显示列表
     *//*
    @RequestMapping
    public String login(){
        return "/user/login";
    }

    *//**
     * 退出登录
     * @param request
     * @return
     *//*
    @RequestMapping(value = "outLogin")
    public String outLogin(HttpServletRequest request){
        UserRoleFilter.logOut(request);
        return "/user/login";
    }

    *//**
     * 显示列表
     *//*
    @RequestMapping(method = RequestMethod.POST)
    public String login(Model model,AuthUserQuery authUserQuery,HttpServletResponse response,HttpServletRequest request){
        if(StringUtils.isNotEmpty(authUserQuery.getLoginName())&&StringUtils.isNotEmpty(authUserQuery.getLoginPwd())){
            //密码加密
            String genMd5Pass = GenerateUtil.genMd5Pass(authUserQuery.getLoginPwd(), authUserQuery.getLoginName());
            authUserQuery.setLoginPwd(genMd5Pass);
            authUserQuery.setDeleteFlag(BossConstant.DELETE_FLAG_YES);
            Human human=new Human();
            human.setDeleteFlag(BossConstant.DELETE_FLAG_YES);
            List<AuthUser> authUserList = authUserService.queryAuthUser(authUserQuery);
            if(authUserList!=null && authUserList.size()>0){
                AuthUser authUser = authUserList.get(0);
                if(authUser.getStatus()!=null){
                    if("460010".equalsIgnoreCase(authUser.getStatus())){
                        model.addAttribute("loginError", "对不起，该账户的状态已受限！");
                        return "/user/login";
                    }else if("460030".equalsIgnoreCase(authUser.getStatus())){
                        model.addAttribute("loginError", "对不起，该账号已被停用！");
                        return "/user/login";
                    } else if("460040".equalsIgnoreCase(authUser.getStatus())){
                        model.addAttribute("loginError", "对不起，该账号已被删除！");
                        return "/user/login";
                    }else{
                        //得到用户角色列表
                        List<AuthRole> authRoleList = authRoleService.queryAuthRole(authUser.getKeyId()+"");
                        //得到用户功能列表
                        List<AuthFunc> authFuncList = authFuncService.queryAuthFunc(authUser.getKeyId()+"");
                        authUser.setAuthFuncList(authFuncList);
                        UserRoleFilter.setAuthUser(request,authUser);
                        //UserRoleFilter.setAuthFunc(request,authFuncList);
                        //request.getSession().setAttribute(BossConstant.USER_SESSION_KEY,authUser);
                        List<AuthFunc> menufuncs= authFuncService.getUserFuncMenu(authFuncList);
                        model.addAttribute("menufuncs", menufuncs);
                        //model.addAttribute("authRoleList", authRoleList);
                        return "index";
                    }
                }else{
                    model.addAttribute("loginError", "该账户没有状态！");
                    return "/user/login";
                }
            }
            else{
                model.addAttribute("loginError", "用户名或密码错误！");
                return "/user/login";
            }
        }
        return "/user/login";
    }*/
    /**
     * 显示列表
     */
    @RequestMapping(value = "/index",method = RequestMethod.POST)
    public String index(Model model){
        return "index";
    }
}
