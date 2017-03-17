package com.altaire.blog.controller.master;

import com.altaire.blog.model.master.Category;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;
import com.altaire.blog.service.impl.master.CategoryServiceImpl;
import com.altaire.blog.service.master.CategoryService;

import java.util.List;

/**
 * Created by cue on 3/10/2017.
 */

@RestController
@RequestMapping(value = "/api/category", produces = "application/json")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    private static final Logger logger = LoggerFactory.getLogger(CategoryServiceImpl.class);

    @RequestMapping(method = RequestMethod.GET)
    public List<Category> findAll() {
        logger.debug("get all category");
        return categoryService.findAll();
    }

    @RequestMapping(value = "/page/{page}/size/{size}", method = RequestMethod.GET)
    public Page<Category> findPageAll(@PathVariable Integer page, @PathVariable Integer size) {
        logger.debug("get all category with page " + page + " and size " + size);
        PageRequest request = new PageRequest(page - 1, size);
        return categoryService.findAll(request);
    }

    @RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
    public Category findById(@PathVariable Long id) {
        logger.debug("get category with id " + id);
        return categoryService.findById(id);
    }

    @RequestMapping(value = "/name/{name}", method = RequestMethod.GET)
    public List<Category> findByName(@PathVariable String name) {
        logger.debug("get category with name like " + name);
        return categoryService.findByName(name);
    }

    @RequestMapping(value = "/name/{name}/page/{page}/size/{size}", method = RequestMethod.GET)
    public Page<Category> findByName(@PathVariable String name, @PathVariable Integer page, @PathVariable Integer size) {
        logger.debug("get category with name like " + name + " page " + page + " size " + size);
        PageRequest request = new PageRequest(page - 1, size);
        return categoryService.findByName(name, request);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Category save(@RequestBody Category category) {
        logger.debug("post category");
        return categoryService.create(category);
    }

    @RequestMapping(value = "/del/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        logger.debug("delete category with id " + id);
        categoryService.delById(id);
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.PUT)
    public Category update(@PathVariable Long id, @RequestBody Category category) {
        logger.debug("update category with id " + id);
        return categoryService.create(category);
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public Category newCategory() {
        return new Category();
    }

}
