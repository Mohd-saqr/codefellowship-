package com.codefellowship.codefellowship.Controller;

import com.codefellowship.codefellowship.Mod_user.AppUser;
import com.codefellowship.codefellowship.Security.UserDetailsShow;
import com.codefellowship.codefellowship.servicses.Services;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AppController {
    @Autowired
    Services services;


    @GetMapping("/home")
    public String Home( ) {
        return "Home";
    }
    @GetMapping("/login")
    String LoginPage(){
        return "loginPage";

    }

    @GetMapping("/signUp")
    String signUpPage(){
        return "signUpPage";
    }
    @GetMapping("/")
    String userPage(Model model){
        return "userPage";
    }

    @PostMapping("/login_form")
    String LogFormPage(@RequestParam String userName ,@RequestParam  String password){
        return "userPage";
    }

//    @PostMapping("/sign_form")
//    String signUpForm(@RequestParam String username,@RequestParam String password ,@RequestParam String firstName ,@RequestParam String lastName ,@RequestParam String dateOfBirth,@RequestParam String bio , Model model){
//        if (services.addNewUser(username,password,firstName,lastName,dateOfBirth,bio,model))return "userPage";
//        return "signUpPage";
//    }

    @ModelAttribute("AppUser")
    public AppUser userRegistrationDto() {
        return new AppUser() ;

        }

    @PostMapping("/signUp")
    String signUpForm(@ModelAttribute("AppUser") AppUser user){

        if (services.addUser(user)){

            return "redirect:/login?success";
        }



        return "redirect:/signUp?error";
    }

//    @PostMapping("/Log_form")
//    String LogFormPage(@RequestParam String userName ,@RequestParam  String password){
//        return "userPage";
//    }

}
