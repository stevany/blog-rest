package com.altaire.blog.service.impl.master;

import com.altaire.blog.model.master.Module;
import com.altaire.blog.repository.master.ModuleRepository;
import com.altaire.blog.service.master.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by cue on 3/16/2017.
 */
@Service
public class ModuleServiceImpl implements ModuleService{
    @Autowired
    private ModuleRepository moduleRepository;

    @Override
    public Module findById(Long id) {
        return moduleRepository.findOne(id);
    }

    @Override
    public Module create(Module module) {
        return moduleRepository.saveAndFlush(module);
    }

    @Override
    public List<Module> findAll() {
        return moduleRepository.findAll();
    }

    @Override
    public List<Module> findByName(String name) {
        return moduleRepository.findByNameLike(name);
    }
}
