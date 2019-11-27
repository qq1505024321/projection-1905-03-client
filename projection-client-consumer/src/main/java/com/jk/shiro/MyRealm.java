
package com.jk.shiro;


import com.alibaba.dubbo.config.annotation.Reference;
import com.jk.model.Users;
import com.jk.service.LoginService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈test〉
 *
 * @author chenchunlan
 * @create 2019/11/14
 * @since 1.0.0
 */
public class MyRealm extends AuthorizingRealm {

    @Reference
   private LoginService loginService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        //获取主身份信息
        Users userCode = (Users)principals.getPrimaryPrincipal();
        List<String> permissions = loginService.selectPowerByUser(userCode);
        

        //根据身份信息获取权限信息
        //模拟从数据库获取到数据
    /*    List<String> permissions = new ArrayList<String>();
        permissions.add("user:create"); //用户的创建权限
        permissions.add("user:update"); //商品的添加权限
        permissions.add("user:delete"); //商品的添加权限*/
        //permissions.add("user:toAdd");
        //将查询到授权信息填充到对象中
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addStringPermissions(permissions);

        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        // 将token装换成UsernamePasswordToken
        UsernamePasswordToken upToken = (UsernamePasswordToken) authenticationToken;
        //1.从token取出用户身份信息
        String username = upToken.getUsername();
        //查询数据库 判断当前user是否为空
        Users user = loginService.queryUserByName(username);
        //如果查询不到则返回null  user==null
        if(!username.equals(user.getUserName())){//这里模拟查询不到
            throw new UnknownAccountException();
        }
        //2.根据用户userCode查询数据库

        //模拟从数据库查询到的密码
        String password = user.getPassWord();

        //String inputPasswordCiph = UserRegisteAndLogin.getInputPasswordCiph(password, username);

        // 获取盐值，即用户名
        ByteSource salt = ByteSource.Util.bytes(username);
        String realmName = this.getName();
        // 将账户名，密码，盐值，realmName实例化到SimpleAuthenticationInfo中交给Shiro来管理


        //查询不到返回null

        //查询到返回认证信息
        SimpleAuthenticationInfo authenticationInfo =  new SimpleAuthenticationInfo(username, password, salt, realmName);
        SecurityUtils.getSubject().getSession().setAttribute("login", username);
        SecurityUtils.getSubject().getSession().setAttribute("userObj", user);
        return authenticationInfo;
    }

}
