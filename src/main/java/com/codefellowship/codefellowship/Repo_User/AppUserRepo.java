package com.codefellowship.codefellowship.Repo_User;

import com.codefellowship.codefellowship.Mod_user.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepo extends JpaRepository<AppUser,Long> {

    AppUser findByusername(String username);
}
