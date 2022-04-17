package com.codefellowship.codefellowship.servicses;
import com.codefellowship.codefellowship.Modul_App.AppUser;
import com.codefellowship.codefellowship.Modul_App.Posts;
import com.codefellowship.codefellowship.Repo_User.AppPostsRepo;
import com.codefellowship.codefellowship.Repo_User.AppUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import java.util.ArrayList;
import java.util.List;

@Service
public class Services implements ServicesMethod {
    @Autowired
    AppUserRepo appUserRepo;
    @Autowired
    PasswordEncoder encoder;
    @Autowired
    AppPostsRepo appPostsRepo;

    @Override
    public boolean addNewUser(String username, String password,
                              String firstName,
                              String lastName, String dateOfBirth,
                              String bio, Model model) {
        AppUser appUser = appUserRepo.findByusername(username);
        if (appUser != null) return false;
        AppUser user = new AppUser(username, encoder.encode(password), firstName, lastName, dateOfBirth, bio);
        appUserRepo.save(user);
        model.addAttribute("UserLog", user);
        return true;
    }

    public Boolean addUser(AppUser user) {
        AppUser appUser = appUserRepo.findByusername(user.getUsername());
        if (appUser != null) return false;
        AppUser user1 = new AppUser(user.getUsername(), encoder.encode(user.getPassword()), user.getFirstName(), user.getLastName(), user.getDateOfBirth(), user.getBio());
        appUserRepo.save(user1);
        return true;
    }

    @Transactional
    public void AddPosts(String body, Long id) {
        AppUser user = appUserRepo.getById(id);
        Posts post = new Posts(body);
        user.getPosts().add(post);
        appUserRepo.save(user);

    }

    @Transactional
    public boolean addLikes(Long postID) {
        Posts post = appPostsRepo.getById(postID);
        post.setLikes(post.getLikes() + 1);
        return true;
    }

    public List<AppUser> getAllUser(Model model) {
        List<AppUser> users = appUserRepo.findAll();
        List<AppUser> usersHavePosts = new ArrayList<>();
        for (AppUser user : users) {
            if (user.getPosts().size() != 0) {
                usersHavePosts.add(user);
            }
        }
        model.addAttribute("users", usersHavePosts);
        return users;
    }

    public void findUser(Long id, Model model) {
        model.addAttribute("user", appUserRepo.getById(id));

    }

    public AppUser findUserByUserName(String userName) {
        return appUserRepo.findByusername(userName);


    }

    @Transactional
    public int followUser(Long userid, Long personId, Model model) {
        AppUser user = appUserRepo.getById(userid);
        AppUser person = appUserRepo.getById(personId);
        if (userid == personId) return -1;
        else if (user.getFollowing().contains(person)) return 0;

        user.getFollowing().add(person);
        person.getFollower().add(user);
//        appUserRepo.save(user);
//        appUserRepo.save(person);
        return 1;
    }


    public List<AppUser> getFollwer(Model model) {

        AppUser user = (AppUser) model.getAttribute("user");

        return appUserRepo.getById(user.getId()).getFollowing();

    }
}
