package com.altaire.blog.controller.master;

import com.altaire.blog.model.dto.RoleDto;
import com.altaire.blog.model.enumeration.Actions;
import com.altaire.blog.model.master.Role;
import com.altaire.blog.service.impl.master.RoleServiceImpl;
import com.altaire.blog.service.master.RoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by cue on 3/10/2017.
 */
@RestController
@RequestMapping(value="/api/role", produces = "application/json")
public class RoleController {
    @Autowired
    private RoleService roleService;
    private static final Logger logger = LoggerFactory.getLogger(RoleServiceImpl.class);

    @RequestMapping(method = RequestMethod.GET)
    public List<Role> findAll() {
        logger.debug("get all roles");
        return roleService.findAll();
    }

    @RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
    public RoleDto findById(@PathVariable Long id) {
        logger.debug("get role with id " + id);
        return roleService.findByDtoId(id);
    }

    @RequestMapping(value = "/name/{name}", method = RequestMethod.GET)
    public List<Role> findByName(@PathVariable String name) {
        logger.debug("get role with name like " + name);
        return roleService.findByName(name);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Role save(@RequestBody RoleDto role) {
        logger.debug("post role");
        return roleService.create(roleService.cloneValueFrom(role));
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.PUT)
    public Role update(@PathVariable Long id, @RequestBody RoleDto role) {
        logger.debug("update role with id " + id);
        return roleService.create(roleService.cloneValueFrom(role));
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public Role newRole() {
        return new Role();
    }
}
