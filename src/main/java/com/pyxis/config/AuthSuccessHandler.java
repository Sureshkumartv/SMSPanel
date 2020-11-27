package com.pyxis.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.pyxis.users.UserToken;

@Component
public class AuthSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
    @Override
    protected String determineTargetUrl(HttpServletRequest request, HttpServletResponse response) {
        // Get the role of logged in user
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        String role = auth.getAuthorities().toString();

        String targetUrl = "";
        
        UserToken user = (UserToken) auth.getPrincipal();
        if(user.getUserType() != 4){
        	targetUrl = "/viewusers.htm";
        }else {
        	targetUrl = "/sendsms.htm";
        }
        System.out.println("    "+targetUrl);
        return targetUrl;
    }
}
