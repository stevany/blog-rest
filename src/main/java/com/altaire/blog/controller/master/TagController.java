package com.altaire.blog.controller.master;

import com.altaire.blog.model.master.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.altaire.blog.service.impl.master.TagServiceImpl;
import com.altaire.blog.service.master.TagService;

import java.util.List;

/**
 * Created by cue on 3/10/2017.
 */

@RequestMapping(value = "/api/tag", produces = "application/json")
@RestController
public class TagController {
    @Autowired
    private TagService tagService;
    private static final Logger logger = LoggerFactory.getLogger(TagServiceImpl.class);

    @RequestMapping(method = RequestMethod.GET)
    public List<Tag> findAll() {
        logger.debug("get all tag");
        return tagService.findAll();
    }

    @RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
    public Tag findById(@PathVariable Long id) {
        logger.debug("get tag with id " + id);
        return tagService.findById(id);
    }

    @RequestMapping(value = "/name/{name}", method = RequestMethod.GET)
    public List<Tag> findByName(@PathVariable String name) {
        logger.debug("get tag with name like " + name);
        return tagService.findByName(name);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Tag save(@RequestBody Tag tag) {
        logger.debug("post tag");
        return tagService.create(tag);
    }

    @RequestMapping(value = "/del/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        logger.debug("delete tag with id " + id);
        tagService.delById(id);
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.PUT)
    public Tag update(@PathVariable Long id, @RequestBody Tag tag) {
        logger.debug("update tag with id " + id);
        return tagService.create(tag);
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public Tag newTag() {
        return new Tag();
    }
}
