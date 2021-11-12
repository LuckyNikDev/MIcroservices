package com.example.auth.zuulFilter;

import com.example.auth.model.User;
import com.example.auth.reposytory.UserRepository;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class MyAddHeaderFilter extends ZuulFilter {
    private UserRepository userRepository;

    @Autowired
    public MyAddHeaderFilter(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

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
            User user = userRepository.findByEmail(authentication.getName()).orElseThrow(() -> new UsernameNotFoundException("User doesn't exists"));
            requestContext.addZuulRequestHeader("USER_ID", user.getId().toString());
            requestContext.addZuulRequestHeader("USER_ROLE", user.getRole().name());
        }
        return requestContext;
    }
}
