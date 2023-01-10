package com.jespApiTest.CarServices.util;

import com.jespApiTest.CarServices.models.Access;
import com.jespApiTest.CarServices.repository.AccessRepository;
import com.jespApiTest.CarServices.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@Slf4j
public class JwtUserDetailsService implements UserDetailsService {

    static final String STANDARD_USER = "STANDARD_USER";
    static final String SERVICE = "SERVICE";
    static final String ADMIN = "ADMIN";

    @Autowired
    UserRepository userRepository;

    @Autowired
    AccessRepository accessRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try{
            Access accessoUtente = accessRepository.findByUsername(username);
            return new User(accessoUtente.getUsername() , accessoUtente.getPassword(), getAuthorities(username));
        }catch (Exception ex){
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
    }

    private Collection<? extends GrantedAuthority> getAuthorities(String username) {

        List<GrantedAuthority> authorities = new ArrayList<>();
        com.jespApiTest.CarServices.models.User user = userRepository.findByUsername(username);
        authorities.add(new SimpleGrantedAuthority(checkGrant(user.getIdRuolo())));
        return authorities;
    }

    private String checkGrant(Integer role){
        switch (role){
            case 1:
                return ADMIN;
            case 2:
                return SERVICE;
            default:
                return STANDARD_USER;
        }
    }
}