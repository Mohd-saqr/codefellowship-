package com.codefellowship.codefellowship.Modul_App;

import javax.persistence.*;
import java.util.List;


@Entity
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private String bio;
    @OneToMany(cascade = CascadeType.ALL ,fetch = FetchType.EAGER)
    private List<Posts> posts;
    @ManyToMany(cascade = CascadeType.ALL ,fetch = FetchType.EAGER)
   @JoinTable(name = "FollowTable" ,joinColumns = {@JoinColumn(name = "followingId")},
   inverseJoinColumns = {@JoinColumn(name = "followerId")})
    private List<AppUser> following;
    @ManyToMany(cascade = CascadeType.ALL ,mappedBy ="following" ,fetch = FetchType.EAGER)
    private List<AppUser>follower;
    public List<Posts> getPosts() {
        return posts;
    }

    public List<AppUser> getFollowing() {
        return following;
    }

    public void setFollowing(List<AppUser> following) {
        this.following = following;
    }

    public List<AppUser> getFollower() {
        return follower;
    }

    public void setFollower(List<AppUser> follower) {
        this.follower = follower;
    }

    public void setPosts(List<Posts> posts) {
        this.posts = posts;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public AppUser() {
    }

    public AppUser(String username, String password, String firstName, String lastName, String dateOfBirth, String bio) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.bio = bio;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getBio() {
        return bio;
    }


}
