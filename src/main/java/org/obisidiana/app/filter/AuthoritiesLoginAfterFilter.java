package org.obisidiana.app.filter;

import jakarta.servlet.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.io.IOException;
import java.util.logging.Logger;

public class AuthoritiesLoginAfterFilter implements Filter {

    private Logger LOG = Logger.getLogger(AuthoritiesLoginAfterFilter.class.getName());
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication != null){
            LOG.info("User "+authentication.getName()
                    +" is succesfully authenticated and "+ "has the authoorities"
                    +authentication.getAuthorities().toString());
        }
        chain.doFilter(request,response);
    }
}
