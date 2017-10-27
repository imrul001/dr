package dr.hasan.aspect.userlogin;

import dr.hasan.clientLogin.service.UserLoginService;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class LogginAroundLoginBusiness implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        Log log = LogFactory.getLog(UserLoginService.class);
        log.info("before executing "+methodInvocation.getMethod().getName());

        String username = (String) methodInvocation.proceed();

        log.info("after executing "+methodInvocation.getMethod().getName());
        return username;
    }
}
