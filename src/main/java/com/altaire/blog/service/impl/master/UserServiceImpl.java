package com.altaire.blog.service.impl.master;

import com.altaire.blog.model.dto.UserDto;
import com.altaire.blog.model.master.Role;
import com.altaire.blog.model.master.User;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import com.altaire.blog.repository.master.UserRepository;
import com.altaire.blog.service.master.UserService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by cue on 3/10/2017.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public void create(User user) {
        userRepository.saveAndFlush(user);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Long id) {
        return userRepository.findOne(id);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User findByUsernameAndPassword(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password);
    }

    @Override
    public UserDto findByDtoId(Long id) {
        return cloneTo(findById(id));
    }


    @Override
    public UserDto cloneTo(User u) {
        UserDto dto=new UserDto();
        dto.setId(u.getId());
        dto.setActive(u.getActive());
        Long[]roles={};
        if(u.getRoles()!=null){
            roles=new Long[u.getRoles().size()];
            int i=0;
            for(Role role:u.getRoles()){
                roles[i]=role.getId();
                i++;
            }
        }
        return dto;
    }

    @Override
    public User cloneValueFrom(UserDto dto) {
        User u=new User();
        u.setUsername(dto.getUsername());
        u.setActive(dto.getActive());
        u.setId(dto.getId());

        if(dto.getRoles()!=null) {
            Set<Role> roles = new HashSet<Role>();
            for (Long id : dto.getRoles()) {
                Role r = new Role();
                r.setId(id);
                roles.add(r);
            }
            u.setRoles(roles);
        }
        return u;
    }
}
