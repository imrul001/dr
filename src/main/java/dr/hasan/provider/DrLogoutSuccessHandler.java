package dr.hasan.provider;

import dr.hasan.clientLogin.entity.UserLogin;
import dr.hasan.clientLogin.service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DrLogoutSuccessHandler extends SimpleUrlLogoutSuccessHandler {

    @Autowired
    private UserLoginService loginService;

    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        String redirectUrl = "/login?logout";
        if (authentication != null) {
            UserLogin userLogin = (UserLogin) authentication.getPrincipal();
            if (loginService.isExist(userLogin)) {
                boolean isUserDeleted = loginService.deleteUser(userLogin);
            }
        }
        request.getSession().invalidate();
        response.sendRedirect(redirectUrl);
        super.onLogoutSuccess(request, response, authentication);
    }

}
