package com.codefellowship.codefellowship.Repo_User;

import com.codefellowship.codefellowship.Modul_App.Posts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppPostsRepo extends JpaRepository<Posts,Long> {
}
