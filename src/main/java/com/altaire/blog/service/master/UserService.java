package com.altaire.blog.service.master;

import com.altaire.blog.model.dto.UserDto;
import com.altaire.blog.model.master.User;

import java.util.List;

/**
 * Created by cue on 3/10/2017.
 */
public interface UserService {
    void create(User user);

    List<User> findAll();

    User findById(Long id);

    User findByUsername(String username);

    User findByUsernameAndPassword(String username, String password);

    UserDto findByDtoId(Long id);

    UserDto cloneTo(User u);
    
    User cloneValueFrom(UserDto dto);
}
