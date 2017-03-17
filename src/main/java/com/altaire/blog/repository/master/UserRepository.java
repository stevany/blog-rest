package com.altaire.blog.repository.master;

import com.altaire.blog.model.master.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by cue on 3/10/2017.
 */
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);

    User findByUsernameAndPassword(String username, String password);
}
