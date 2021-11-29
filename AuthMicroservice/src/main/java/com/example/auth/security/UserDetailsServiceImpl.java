package com.example.auth.security;

import com.example.auth.model.User;
import com.example.auth.reposytory.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service("userDetailsServiceImpl")
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("User doesn't exists"));
        return new SecurityUser(user.getEmail(), user.getPassword(),
                Stream.<SimpleGrantedAuthority>builder().add(new SimpleGrantedAuthority("ROLE_" + user.getRole().name())).build().collect(Collectors.toList()),
                user.isStatus());
    }
}
