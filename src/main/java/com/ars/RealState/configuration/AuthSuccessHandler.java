/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ars.RealState.configuration;

import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

/**
 *
 * @author stim
 */
public class AuthSuccessHandler
        extends SavedRequestAwareAuthenticationSuccessHandler {
//    @Override
//    protected String determineTargetUrl(HttpServletRequest request, HttpServletResponse response) {
//        // Get the role of logged in user
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        String role = auth.getAuthorities().toString();
//
//        String targetUrl = "";
//        if(role.contains("ROLE_USER")) {
//            targetUrl = "/User/Home";
//        } 
//        else if(role.contains("ROLE_ADMIN")) {
//            targetUrl = "/Admin/Home";
//        }
//        return targetUrl;
//    }
    
}
