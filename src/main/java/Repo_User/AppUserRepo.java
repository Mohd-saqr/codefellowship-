package Repo_User;

import Mod_user.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepo extends JpaRepository<AppUser,Long> {

    AppUser findByUserName(String username);
}
