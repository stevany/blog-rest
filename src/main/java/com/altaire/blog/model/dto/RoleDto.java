package com.altaire.blog.model.dto;

import com.altaire.blog.model.master.Module;
import com.altaire.blog.model.master.User;

import java.util.Set;

/**
 * Created by cue on 3/16/2017.
 */
public class RoleDto {
    private Long id;
    private String name;
    private Long[] modules;

    public RoleDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long[] getModules() {
        return modules;
    }

    public void setModules(Long[] modules) {
        this.modules = modules;
    }
}
