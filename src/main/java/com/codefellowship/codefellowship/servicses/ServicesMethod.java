package com.codefellowship.codefellowship.servicses;

import org.springframework.ui.Model;

public interface ServicesMethod {
    boolean addNewUser(String username,  String password ,
                    String firstName ,
                    String lastName ,  String dateOfBirth,
                    String bio, Model model);

}


