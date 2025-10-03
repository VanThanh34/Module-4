package com.codegym.c0525g1_spring_boot.service.impl;

import com.codegym.c0525g1_spring_boot.dto.UserInfoUserDetails;
import com.codegym.c0525g1_spring_boot.entity.AppUser;
import com.codegym.c0525g1_spring_boot.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserInforDetailService implements UserDetailsService {
    @Autowired
    private IUserRepository iUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUser = iUserRepository.findByUserName(username);
        if(appUser == null) {
            throw new UsernameNotFoundException("User not found!");
        }
//        Lấy tất cả role của AppUser
        UserInfoUserDetails infoUserDetails = new UserInfoUserDetails(appUser);
        return infoUserDetails;
    }
}
