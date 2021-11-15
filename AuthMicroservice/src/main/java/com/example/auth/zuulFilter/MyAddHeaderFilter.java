package com.example.auth.zuulFilter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class MyAddHeaderFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        RequestContext requestContext = RequestContext.getCurrentContext();
        if (authentication != null) {
            requestContext.addZuulRequestHeader("USER_ID", authentication.getName());
            requestContext.addZuulRequestHeader("USER_ROLE", authentication.getAuthorities().toString());
        }
        return requestContext;
    }
}
