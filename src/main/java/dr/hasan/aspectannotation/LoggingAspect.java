package dr.hasan.aspectannotation;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class LoggingAspect {

    @Before("execution(* dr.hasan.clientLogin.service.UserLoginService.getUserName(..))")
    public void logBefore(JoinPoint joinPoint){
        Log log = LogFactory.getLog(LoggingAspect.class);
        log.info("logBefore is running");
        log.info(joinPoint.getSignature().getName());
        log.info("******************");
    }

    @After("execution(* dr.hasan.clientLogin.service.UserLoginService.getUserName(..))")
    public void logAfter(JoinPoint joinPoint){
        Log log = LogFactory.getLog(LoggingAspect.class);
        log.info("logAfter is running");
        log.info(joinPoint.getSignature().getName());
        log.info("******************");
    }
}
