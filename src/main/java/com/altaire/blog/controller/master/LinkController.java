package com.altaire.blog.controller.master;

import com.altaire.blog.model.master.Link;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.altaire.blog.service.impl.master.LinkServiceImpl;
import com.altaire.blog.service.master.LinkService;

import java.util.List;

/**
 * Created by cue on 3/10/2017.
 */

@RequestMapping(value = "/api/link", produces = "application/json")
@RestController
public class LinkController {
    @Autowired
    private LinkService linkService;
    private static final Logger logger = LoggerFactory.getLogger(LinkServiceImpl.class);

    @RequestMapping(method = RequestMethod.GET)
    public List<Link> findAll() {
        logger.debug("get all links");
        return linkService.findAll();
    }

    @RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
    public Link findById(@PathVariable Long id) {
        logger.debug("get link with id " + id);
        return linkService.findById(id);
    }

    @RequestMapping(value = "/name/{name}", method = RequestMethod.GET)
    public List<Link> findByName(@PathVariable String name) {
        logger.debug("get link with name like " + name);
        return linkService.findByName(name);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Link save(@RequestBody Link link) {
        logger.debug("post link");
        return linkService.create(link);
    }

    @RequestMapping(value = "/del/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        logger.debug("delete link with id " + id);
        linkService.delById(id);
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.PUT)
    public Link update(@PathVariable Long id, @RequestBody Link link) {
        logger.debug("update link with id " + id);
        return linkService.create(link);
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public Link newLink() {
        return new Link();
    }
}
