package dr.hasan.provider;

import dr.hasan.clientLogin.entity.UserLogin;
import dr.hasan.clientLogin.service.UserLoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.session.SessionDestroyedEvent;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Imrul Hasan
 * @date 16/03/19
 */
@Component
public class SessionTimeoutHandler implements ApplicationListener<SessionDestroyedEvent> {

    private static final Logger logger = LoggerFactory.getLogger(SessionTimeoutHandler.class);

    @Autowired
    private UserLoginService userLoginService;

    @Override
    public void onApplicationEvent(SessionDestroyedEvent sessionDestroyedEvent) {
        try {
            List<SecurityContext> securityContexts = sessionDestroyedEvent.getSecurityContexts();
            for (SecurityContext securityContext : securityContexts) {
                UserLogin userLogin = (UserLogin) securityContext.getAuthentication().getPrincipal();
                if (userLogin != null) {
                    userLoginService.deleteUser(userLogin);
                    logger.info("user deleted successfully. Deleted User's email : {}",userLogin.getEmail());
                }
            }
        } catch (Exception e) {
            logger.error("error due to {}", e.getMessage(), e);
        }
    }
}
