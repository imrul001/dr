package dr.hasan.aspect.userlogin;

import dr.hasan.clientLogin.service.UserLoginService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

public class LogginBeforeUserLoginBusiness implements MethodBeforeAdvice {

    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        Log log = LogFactory.getLog(UserLoginService.class);
        log.info("before executing business of "+o.getClass());
    }
}
