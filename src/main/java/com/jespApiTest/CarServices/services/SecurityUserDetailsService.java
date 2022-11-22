package com.jespApiTest.CarServices.services;

import com.jespApiTest.CarServices.models.Access;
import com.jespApiTest.CarServices.repository.AccessRepository;
import com.jespApiTest.CarServices.repository.UserRepository;
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
public class SecurityUserDetailsService implements UserDetailsService {

    static final String STANDARD_USER = "STANDARD_USER";
    static final String SERVICE = "SERVICE";
    static final String ADMIN = "ADMIN";

    /**
     * Autowired authentication repository for authentication with database
     */
    @Autowired
    private AccessRepository authenticationRepository;

    /**
     * Autowired user repostiory for query operation with user
     */
    @Autowired
    private UserRepository userRepository;

    /**
     * Override method to load a user by username
     *
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try{
            Access authUser = authenticationRepository.findByUsername(username);
            return new User(authUser.getUsername(), authUser.getPassword(), getAuthorities(username));
        }catch (Exception ex){
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
    }

    /**
     * Private method for get all granted authorities
     *
     * @param username
     * @return
     */
    private Collection<? extends GrantedAuthority> getAuthorities(String username) {
        List<GrantedAuthority> authorities = new ArrayList<>();

        com.jespApiTest.CarServices.models.User user = userRepository.findByUsername(username);
        authorities.add(new SimpleGrantedAuthority(checkGrant(user.getIdRuolo())));
        return authorities;
    }

    /**
     * Get grant by User role
     *
     * @param role
     * @return
     */
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