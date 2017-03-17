package com.altaire.blog.service.master;

import com.altaire.blog.model.master.Module;

import java.util.List;

/**
 * Created by cue on 3/16/2017.
 */
public interface ModuleService {
    Module findById(Long id);

    Module create(Module module);

    List<Module> findAll();

    List<Module> findByName(String name);



}
