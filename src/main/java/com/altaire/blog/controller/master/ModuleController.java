package com.altaire.blog.controller.master;

import com.altaire.blog.model.master.Module;
import com.altaire.blog.service.impl.master.ModuleServiceImpl;
import com.altaire.blog.service.master.ModuleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by cue on 3/16/2017.
 */
@RestController
@RequestMapping(value="/api/module", produces = "application/json")
public class ModuleController {
    @Autowired
    private ModuleService moduleService;
    private static final Logger logger = LoggerFactory.getLogger(ModuleServiceImpl.class);

    @RequestMapping(method = RequestMethod.GET)
    public List<Module> findAll() {
        logger.debug("get all module");
        return moduleService.findAll();
    }

    @RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
    public Module findById(@PathVariable Long id) {
        logger.debug("get module with id " + id);
        return moduleService.findById(id);
    }

    @RequestMapping(value = "/name/{name}", method = RequestMethod.GET)
    public List<Module> findByName(@PathVariable String name) {
        logger.debug("get module with name like " + name);
        return moduleService.findByName(name);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Module save(@RequestBody Module module) {
        logger.debug("post module");
        return moduleService.create(module);
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.PUT)
    public Module update(@PathVariable Long id, @RequestBody Module module) {
        logger.debug("update module with id " + id);
        return moduleService.create(module);
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public Module newModule() {
        return new Module();
    }
}
