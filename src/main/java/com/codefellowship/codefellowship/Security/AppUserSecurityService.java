package com.codefellowship.codefellowship.Security;

import com.codefellowship.codefellowship.Modul_App.AppUser;
import com.codefellowship.codefellowship.Repo_User.AppUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AppUserSecurityService implements UserDetailsService {
    @Autowired
    AppUserRepo appUserRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser user =appUserRepo.findByusername(username);
        if (user!=null){
            return new UserDetailsShow(user);
        }
        return null;
    }
}
