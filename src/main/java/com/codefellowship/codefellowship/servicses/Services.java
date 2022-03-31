package com.codefellowship.codefellowship.servicses;

import com.codefellowship.codefellowship.Mod_user.AppUser;
import com.codefellowship.codefellowship.Repo_User.AppUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class Services implements ServicesMethod{
    @Autowired
    AppUserRepo appUserRepo;
    @Autowired
    PasswordEncoder encoder;
    @Override
    public boolean addNewUser( String username,  String password ,
                            String firstName ,
                            String lastName ,  String dateOfBirth,
                            String bio, Model model) {
        AppUser appUser=appUserRepo.findByusername(username);
        if (appUser!=null)return false;
        AppUser user = new AppUser(username,encoder.encode(password),firstName,lastName,dateOfBirth,bio);
        appUserRepo.save(user);
        model.addAttribute("UserLog",user);
        return true;
    }

    public Boolean addUser(AppUser user){
        AppUser appUser=appUserRepo.findByusername(user.getUsername());
        if (appUser!=null)return false;
        AppUser user1 = new AppUser(user.getUsername(),encoder.encode(user.getPassword()),user.getFirstName(),user.getLastName(),user.getDateOfBirth(),user.getBio());
        appUserRepo.save(user1);
        return true;
    }
}
