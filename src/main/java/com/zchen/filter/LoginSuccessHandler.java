package com.zchen.filter;

import org.apache.log4j.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Zhouce Chen
 * @version Nov 23, 2013
 */
public class LoginSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
    private final Logger logger = Logger.getLogger(LoginSuccessHandler.class);

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        logger.info("User [" + userDetails.getUsername() + "] logs in successfully.");
        request.getSession().setAttribute("account", userDetails);
        super.onAuthenticationSuccess(request, response, authentication);
    }
}
