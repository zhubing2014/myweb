package com.zchen.filter;

import org.apache.log4j.Logger;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Zhouce Chen
 * @version Nov 23, 2013
 */
public class LoginFailureHandler extends SimpleUrlAuthenticationFailureHandler {
    Logger logger = Logger.getLogger(LoginFailureHandler.class);

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
//        request.setAttribute(WebAttributes.AUTHENTICATION_EXCEPTION, "Username or password is wrong.");
        super.onAuthenticationFailure(request, response, exception);
    }
}
