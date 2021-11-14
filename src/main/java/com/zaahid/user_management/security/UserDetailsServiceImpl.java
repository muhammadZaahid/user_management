package com.zaahid.user_management.security;


import com.zaahid.user_management.model.UserAuth;
import com.zaahid.user_management.repository.UserAuthRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailsServiceImpl implements UserDetailsService{

    @Autowired
    private UserAuthRepository userAuthRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserAuth userAuth = userAuthRepository.getUserByUsername(username);
        if(userAuth==null){
            throw new UsernameNotFoundException("Coull not find USer");
        }
        return new MyUserDetails(userAuth);
    }
    
}
