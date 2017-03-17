package com.altaire.blog.controller.transaction;

import com.altaire.blog.model.dto.ArticleDto;
import com.altaire.blog.model.enumeration.Actions;
import com.altaire.blog.model.transaction.Article;
import com.altaire.blog.service.master.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;
import com.altaire.blog.service.impl.transaction.ArticleServiceImpl;
import com.altaire.blog.service.transaction.ArticleService;

import javax.swing.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by cue on 3/10/2017.
 */

@RequestMapping(value = "/api/article", produces = "application/json")
@RestController
public class ArticleController {
    @Autowired
    private ArticleService articleService;
    @Autowired
    private UserService userService;

    private static final Logger logger = LoggerFactory.getLogger(ArticleServiceImpl.class);

    @RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
    public ArticleDto findById(@PathVariable Long id) {
        logger.debug("get article with id " + id);
        return articleService.findByDtoId(id);
    }

    @RequestMapping(value = "/page/{page}/size/{size}", method = RequestMethod.GET)
    public Page<Article> findAll(@PathVariable Integer page, @PathVariable Integer size) {
        logger.debug("get article with page " + page + " and size " + size);
        PageRequest request = new PageRequest(page - 1, size);
        return articleService.findAll(request);
    }

    @RequestMapping(value = "/user/{userId}/page/{page}/size/{size}", method = RequestMethod.GET)
    public Page<Article> findByUser(@PathVariable Long userId, @PathVariable Integer page, @PathVariable Integer size) {
        logger.debug("get article with user " + userId + ", page " + page + " and size " + size);
        PageRequest request = new PageRequest(page - 1, size);
        return articleService.findByUser(userId, request);
    }

    @RequestMapping(value = "/name/{name}/page/{page}/size/{size}", method = RequestMethod.GET)
    public Page<Article> findByName(@PathVariable String name, @PathVariable Integer page, @PathVariable Integer size) {
        logger.debug("get article with name like " + name + " , page " + page + " and size " + size);
        PageRequest request = new PageRequest(page - 1, size);
        return articleService.findByName(name, request);
    }

    @RequestMapping(value = "/category/{id}/page/{page}/size/{size}", method = RequestMethod.GET)
    public Page<Article> findByCategory(@PathVariable Long id, @PathVariable Integer page, @PathVariable Integer size) {
        logger.debug("get article with category " + id + " , page " + page + " and size " + size);
        PageRequest request = new PageRequest(page - 1, size);
        return articleService.findByCategory(id, request);
    }

    @RequestMapping(value = "/d1/{d1}/d2/{d2}/page/{page}/size/{size}", method = RequestMethod.GET)
    public Page<Article> findByDate(@PathVariable String d1, @PathVariable String d2,
                                    @PathVariable Integer page, @PathVariable Integer size) throws ParseException {
        logger.debug("get article with date between " + d1 + " and " + d2 + " , page " + page + " and size " + size);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date from = sdf.parse(d1);
        Date to = sdf.parse(d2);
        PageRequest request = new PageRequest(page - 1, size);
        return articleService.findByDateCreated(from, to, request);
    }

    @RequestMapping(value = "/name/{name}/d1/{d1}/d2/{d2}/page/{page}/size/{size}", method = RequestMethod.GET)
    public Page<Article> findByNameAndDate(@PathVariable String name, @PathVariable String d1, @PathVariable String d2,
                                           @PathVariable Integer page, @PathVariable Integer size) throws ParseException {
        logger.debug("get article with name " + name + ", date between " + d1 + " and " + d2 + " , page " + page + " and size " + size);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date from = sdf.parse(d1);
        Date to = sdf.parse(d2);
        PageRequest request = new PageRequest(page - 1, size);
        return articleService.findByNameAndDateCreated(name, from, to, request);
    }

    @RequestMapping(value = "/tag/{id}/page/{page}/size/{size}", method = RequestMethod.GET)
    public Page<Article> findByTag(@PathVariable Long id, @PathVariable Integer page, @PathVariable Integer size) throws ParseException {
        logger.debug("get article with tag like " + id + " , page " + page + " and size " + size);
        PageRequest request = new PageRequest(page - 1, size);
        return articleService.findByTag(id, request);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Article save(@RequestBody ArticleDto article) {
        logger.debug("post article");
        return articleService.create(articleService.cloneValueFrom(article, Actions.C.getActions()));
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.PUT)
    public Article update(@PathVariable Long id, @RequestBody ArticleDto article) {
        logger.debug("update article with id " + id);
        return articleService.create(articleService.cloneValueFrom(article, Actions.U.getActions()));
    }

    @RequestMapping(value = "/del/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        logger.debug("delete article along with discusses in the article, id  " + id);
        articleService.delById(id);

    }

    @RequestMapping(value = "/name/{name}/user/{userId}/page/{page}/size/{size}", method = RequestMethod.GET)
    public Page<Article> findByUserAndName(@PathVariable String name, @PathVariable Long userId, @PathVariable Integer page, @PathVariable Integer size) {
        logger.debug("get article with name like " + name + " , user " + userId + " , page " + page + " and size " + size);
        PageRequest request = new PageRequest(page - 1, size);
        return articleService.findByUserAndName(userId, name, request);
    }

    @RequestMapping(value = "/category/{categoryId}/user/{userId}/page/{page}/size/{size}", method = RequestMethod.GET)
    public Page<Article> findByUserAndCategory(@PathVariable Long categoryId, @PathVariable Long userId, @PathVariable Integer page, @PathVariable Integer size) {
        logger.debug("get article with category " + categoryId + " , user " + userId + " , page " + page + " and size " + size);
        PageRequest request = new PageRequest(page - 1, size);
        return articleService.findByUserAndCategory(userId, categoryId, request);
    }

    @RequestMapping(value = "/date/{date}/user/{userId}/page/{page}/size/{size}", method = RequestMethod.GET)
    public Page<Article> findByUserAndDate(@PathVariable String date, @PathVariable Long userId, @PathVariable Integer page, @PathVariable Integer size) throws ParseException {
        logger.debug("get article with date " + date + " , user " + userId + " , page " + page + " and size " + size);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date created = sdf.parse(date);
        PageRequest request = new PageRequest(page - 1, size);
        return articleService.findByUserAndDateCreated(userId, created, request);
    }

    @RequestMapping(value = "/tag/{id}/user/{userId}/page/{page}/size/{size}", method = RequestMethod.GET)
    public Page<Article> findByUserAndTag(@PathVariable Long tagId, @PathVariable Long userId, @PathVariable Integer page, @PathVariable Integer size) throws ParseException {
        logger.debug("get article with tag " + tagId + " , user " + userId + " , page " + page + " and size " + size);
        PageRequest request = new PageRequest(page - 1, size);
        return articleService.findByUserAndTag(userId, tagId, request);
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public Article newArticle() {
        return new Article();
    }
}
