package platform.sunshine.security;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import platform.sunshine.form.LoginForm;
import platform.sunshine.model.Account;
import platform.sunshine.service.WriterService;
import platform.sunshine.utils.CommonValue;
import platform.sunshine.utils.ResponseCode;
import platform.sunshine.utils.ResultData;

/**
 * Created by sunshine on 2015/8/14.
 */
public class ShiroRealm extends AuthorizingRealm {
    @Autowired
    private WriterService writerService;

    /**
     * 登录验证
     *
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        LoginForm form = new LoginForm();
        form.setEmail(token.getUsername());
        form.setPassword(new String(token.getPassword()));
        ResultData result = writerService.login(form);
        if (result.getResponseCode() == ResponseCode.RESPONSE_OK) {
            Account account = (Account) result.getData();
            if (account != null) {
                Subject subject = SecurityUtils.getSubject();
                if (subject != null) {
                    Session session = subject.getSession();
                    session.setAttribute(CommonValue.LOGIN_USER, account);
                }
                return new SimpleAuthenticationInfo(account, token.getPassword(), getName());
            }
        }
        return null;
    }

    /**
     * 权限检查
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        return info;
    }
}
