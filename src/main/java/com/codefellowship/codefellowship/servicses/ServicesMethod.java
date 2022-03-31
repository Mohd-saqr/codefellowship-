package com.codefellowship.codefellowship.servicses;

import com.codefellowship.codefellowship.Mod_user.AppUser;
import org.springframework.ui.Model;

public interface ServicesMethod {
    boolean addNewUser(String username,  String password ,
                    String firstName ,
                    String lastName ,  String dateOfBirth,
                    String bio, Model model);

}
