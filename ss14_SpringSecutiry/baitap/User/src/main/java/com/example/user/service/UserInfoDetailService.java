package com.example.user.service;

import com.example.user.dto.UserInfoUserDetails;
import com.example.user.entity.AppUser;
import com.example.user.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserInfoDetailService implements UserDetailsService {
    private final IUserRepository iUserRepository;


    public UserInfoDetailService(IUserRepository iUserRepository) {
        this.iUserRepository = iUserRepository;
    }

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
