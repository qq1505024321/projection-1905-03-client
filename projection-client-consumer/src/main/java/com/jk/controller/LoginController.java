package com.jk.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSONObject;
import com.jk.httpclient.HttpClientUtil;
import com.jk.model.Codes;
import com.jk.model.Users;
import com.jk.service.LoginService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author Administrator
 * @create 2019/11/14
 * @since 1.0.0
 */
@Controller
public class LoginController {

    @Reference
    private LoginService loginService;

    @Autowired
    private RedisTemplate redisTemplate;


    @RequestMapping("findUser")
    @ResponseBody
    public Map findUser(Integer rows,Integer page){
        return loginService.findUser(rows,page);
    }


    /**
     * 查询用户信息
     * @return
     */
    @RequestMapping("findFunctionId")
    @ResponseBody
    public List<Map> findFunctionId(){
        return loginService.findFunctionId();
    }

    /**
     * 登录成功去index页面
     * @return
     */
    @RequestMapping("index2")
    public String toIndex () {
      // Users userObj = (Users) SecurityUtils.getSubject().getSession().getAttribute("userObj");
      //  System.out.println(userObj+"===========");
        return "index2";
    }

    /**
     *去登录页面
     * @return
     */
    @RequestMapping("toLogin")
    public String toLogin () {
        //获取登录的用户信息
        Object userObj = SecurityUtils.getSubject().getSession().getAttribute("userObj");
        //判断有没有用户登录过，如果已经有用户登陆过 登出 （清除session）避免用户登录之后不能二次登陆的问题
        if(userObj!=null){
            SecurityUtils.getSubject().logout();
        }
        return "login";
    }

    /**
     * 登录提交表单用shiro验证
     * @param request
     * @param model
     * @return
     */
   @RequestMapping("login")
    public String login(HttpServletRequest request, Model model){

        String shiroLoginFailure = request.getAttribute("shiroLoginFailure").toString();

        if(UnknownAccountException.class.getName().equals(shiroLoginFailure) || AuthenticationException.class.getName().equals(shiroLoginFailure)){
            model.addAttribute("msg","用户名输入错误 UnknownAccountException");
        }else if (IncorrectCredentialsException.class.getName( ).equals(shiroLoginFailure)){
            model.addAttribute("msg","密码错误 IncorrectCredentialsException");
        }

        return "login";
    }



    /**
     * 去注册页面
     * @return
     */
    @RequestMapping("toRegister")
    public String toRegister(){
        return "register";
    }
    @RequestMapping("toRegister2")
    public String toRegister2(){
        return "register2";
    }

    @RequestMapping("getCode")
    @ResponseBody
    public String getCode(String mobile,HttpServletRequest request){
        String url = "https://api.netease.im/sms/sendcode.action";
        HashMap<String, String> map = new HashMap<>();
        Codes codeObj = new Codes();
        String doPost = "";
        doPost = (String) redisTemplate.opsForValue().get(mobile+"_code");
        if(doPost!=null){
            codeObj = JSONObject.parseObject(doPost, Codes.class);

            //request.setAttribute("codeObj", codeObj);
        }else{
            map.put("mobile", mobile);
            map.put("templateid","14827169");
            HttpClientUtil httpClientUtil = new HttpClientUtil();
            doPost = httpClientUtil.doPost(url, map, "utf-8");
            redisTemplate.opsForValue().set(mobile+"_code", doPost,300, TimeUnit.SECONDS);
		   /* stringRedisTemplate.opsForValue().set("test1", "abc");
		    stringRedisTemplate.expire("test1", 30, TimeUnit.SECONDS);*/
        }
        return doPost;
    }

    @RequestMapping("phoneLogin")
    @ResponseBody
    public int phonelogin(String phonenum,String code){
        int flag = -1;
        String doPost = (String) redisTemplate.opsForValue().get(phonenum+"_code");
        Codes codeObj = JSONObject.parseObject(doPost, Codes.class);
        System.out.println(codeObj.getObj()+"=========");
        System.out.println(code+"===============");
        if(codeObj.getObj().equals(code)){
            flag = 1;
        }
        System.out.println(flag+"+++++");
        return flag;
    }

    @RequestMapping("goProtocol")
    public String goProtocol(){
        return "protocol";
    }





    /**
     * 注册用户信息
     * @param user
     * @return
     */
    @RequestMapping("register")
    public String register(Users user){
       //身份认证
      /* if(user.getUserType()==2){
            loginService.identification(user.getUserName(), front, back);
        }*/

            boolean flag = loginService.saveUser(user);
            if(flag){
                return toLogin();
            }
            return toRegister();
        }



    /**
     * 去修改密码页面
     * @param userName
     * @param request
     * @return
     */
    @RequestMapping("toEditPwd")
    public String toEditPwd(String userName,HttpServletRequest request){
        request.getSession().setAttribute("userNameToEditPwd",userName);
        return "editPwd";
    }

    @RequestMapping("editPwd")
    public String editPwd(String password,String phoneNumber,HttpServletRequest request){
        String userName = (String) request.getSession().getAttribute("userNameToEditPwd");
        System.out.println(password+"-"+phoneNumber+"-"+userName);
        loginService.updatePwdByUserNameAndPhoneNumber(password,phoneNumber,userName);
        return toLogin();
    }

    @RequestMapping("regPhoneNumber")
    @ResponseBody
    public int regPhoneNumber(String phoneNumber,HttpServletRequest request){
        String userName = (String) request.getSession().getAttribute("userNameToEditPwd");
        int flag = -1;
        Users user = loginService.queryUserByName(userName);
        if(user!=null && user.getPhoneNumber().equals(phoneNumber)){
            flag = 1;
        }
        return flag;
    }





}