package com.altaire.blog.model.master;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by cue on 3/10/2017.
 */
@Entity
@Table(name = "role")
public class Role {
    private Long id;
    private String name;

    private Set<Module>modules;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    @ManyToMany
    @JoinTable(name = "role_module", joinColumns = @JoinColumn(name = "role_id"), inverseJoinColumns = @JoinColumn(name = "module_id"))
    public Set<Module> getModules() {
        return modules;
    }

    public void setModules(Set<Module> modules) {
        this.modules = modules;
    }
}
