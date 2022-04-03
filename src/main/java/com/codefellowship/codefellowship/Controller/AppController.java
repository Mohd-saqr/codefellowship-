package com.codefellowship.codefellowship.Controller;

import com.codefellowship.codefellowship.Modul_App.AppUser;
import com.codefellowship.codefellowship.Modul_App.Posts;
import com.codefellowship.codefellowship.servicses.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AppController {
    @Autowired
    Services services;

    // home page
    @GetMapping("/")
    public String Home() {
        return "Home";
    }

    // login page
    @GetMapping("/login")
    String LoginPage() {
        return "loginPage";

    }

    // about us page
    @GetMapping("/aboutUs")
    String homePage() {

        return "AboutUs";
    }

    //sign up page
    @GetMapping("/signUp")
    String signUpPage() {
        return "signUpPage";
    }

    // home page for user logged
    @GetMapping("/home")
    String userPage(Model model, Authentication authentication) {
        model.addAttribute("user", authentication.getPrincipal());
        services.getAllUser(model);

        return "userPage";
    }

    // login form
    @PostMapping("/login_form")
    void LogFormPage(@RequestParam String userName, @RequestParam String password, Model model) {
    }

    // error page
    @GetMapping("/error")
    String errorPage() {
        return "error";
    }

    // define model object name appUser
    @ModelAttribute("AppUser")
    public AppUser userRegistrationDto() {
        return new AppUser();
    }


    // sign up form
    @PostMapping("/signUp")
    String signUpForm(@ModelAttribute("AppUser") AppUser user) {
        if (services.addUser(user)) {

            return "redirect:/login?success";
        }
        return "redirect:/signUp?error";
    }

    // add posts routs or form
    @PostMapping("/addPosts")
    String addPosts(@RequestParam String body, @RequestParam Long id) {
        services.AddPosts(body, id);
        return "redirect:/home";
    }

    // TODO: 4/4/2022 i will make it in future to like post
    @PostMapping("/{postID}/{likeID}")
    void addLike(@PathVariable Long postID) {
        services.addLikes(postID);

    }

    // get user info by id
    @GetMapping("/user/{id}")
    String User(Model model, @PathVariable Long id) {

        services.findUser(id, model);
        return "userPageInfo";
    }


}
