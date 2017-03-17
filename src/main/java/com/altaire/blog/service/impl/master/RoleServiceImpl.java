package com.altaire.blog.service.impl.master;

import com.altaire.blog.model.dto.RoleDto;
import com.altaire.blog.model.master.Module;
import com.altaire.blog.model.master.Role;
import com.altaire.blog.repository.master.RoleRepository;
import com.altaire.blog.service.master.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by cue on 3/10/2017.
 */
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired private RoleRepository roleRepository;

    @Override
    public Role findById(Long id) {
        return roleRepository.findOne(id);
    }

    @Override
    public Role create(Role role) {
        return roleRepository.saveAndFlush(role);
    }

    @Override
    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    @Override
    public List<Role> findByName(String name) {
        return roleRepository.findByNameLike(name);
    }

    @Override
    public RoleDto findByDtoId(Long id) {
        return cloneTo(findById(id));
    }


    @Override
    public RoleDto cloneTo(Role r) {
        RoleDto dto=new RoleDto();
        dto.setId(r.getId());
        dto.setName(r.getName());
        Long[]modules={};
        if(r.getModules()!=null){
            modules=new Long[r.getModules().size()];
            int i=0;
            for(Module m:r.getModules()){
                modules[i]=m.getId();
                i++;
            }
        }
        return dto;
    }

    @Override
    public Role cloneValueFrom(RoleDto dto) {
        Role r=new Role();
        r.setName(dto.getName());
        r.setId(dto.getId());

        if(dto.getModules()!=null){
        Set<Module> modules=new HashSet<Module>();
        for(Long id:dto.getModules()){
            Module m=new Module();
            m.setId(id);
            modules.add(m);
        }
        r.setModules(modules);
        }
        return r;
    }
}
