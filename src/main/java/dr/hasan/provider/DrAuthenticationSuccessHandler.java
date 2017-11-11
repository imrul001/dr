package dr.hasan.provider;

import dr.hasan.clientLogin.entity.UserLogin;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class DrAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {


    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String redirectUrl = "/";
        if (auth != null) {
            UserLogin userLogin = (UserLogin) auth.getPrincipal();
            Cookie cookie = new Cookie("email", "");
            cookie.setMaxAge(0);
            cookie.getSecure();
            response.addCookie(cookie);

            redirectUrl = "/summary";
            request.getSession().setAttribute("email", userLogin.getEmail());
            request.getSession().setAttribute("loginTime", userLogin.getLoginTime());
            request.getSession().setAttribute("userLoginId", userLogin.getId());
            request.getSession().setAttribute("token", userLogin.getToken());
        }
        response.sendRedirect(redirectUrl);
        super.onAuthenticationSuccess(request, response, auth);
    }
}
