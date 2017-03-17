package com.altaire.blog.service.master;

import com.altaire.blog.model.dto.RoleDto;
import com.altaire.blog.model.master.Role;

import java.util.List;

/**
 * Created by cue on 3/10/2017.
 */
public interface RoleService {
    Role findById(Long id);

    Role create(Role role);

    List<Role> findAll();

    List<Role> findByName(String name);

    RoleDto findByDtoId(Long id);

    RoleDto cloneTo(Role r);
    
    Role cloneValueFrom(RoleDto dto);
}
