package com.altaire.blog.controller.transaction;

import com.altaire.blog.model.dto.DiscussionDto;
import com.altaire.blog.model.transaction.Discussion;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;
import com.altaire.blog.service.impl.transaction.DiscussionServiceImpl;
import com.altaire.blog.service.transaction.DiscussionService;

/**
 * Created by cue on 3/10/2017.
 */

@RequestMapping(value = "/api/article", produces = "application/json")
@RestController
public class DiscussionController {
    @Autowired
    private DiscussionService discussionService;

    private static final Logger logger = LoggerFactory.getLogger(DiscussionServiceImpl.class);

    @RequestMapping(value = "/{articleId}/discussion/page/{page}/size/{size}", method = RequestMethod.GET)
    public Page<Discussion> findAll(@PathVariable Long articleId, @PathVariable Integer page, @PathVariable Integer size) {
        logger.debug("get all discussion with article " + articleId + " , page " + page + " and size " + size);
        PageRequest request = new PageRequest(page - 1, size);
        return discussionService.findByArticle(articleId, request);
    }

    @RequestMapping(value = "/discussion/user/{userId}/page/{page}/size/{size}", method = RequestMethod.GET)
    public Page<Discussion> findByUser(@PathVariable Long userId, @PathVariable Integer page, @PathVariable Integer size) {
        logger.debug("get all discussion with user " + userId + " , page " + page + " and size " + size);
        PageRequest request = new PageRequest(page - 1, size);
        return discussionService.findByUser(userId, request);
    }

    @RequestMapping(value = "/{articleId}/discussion/user/{userId}/page/{page}/size/{size}", method = RequestMethod.GET)
    public Page<Discussion> findByUserAndArticle(@PathVariable Long articleId, @PathVariable Long userId, @PathVariable Integer page, @PathVariable Integer size) {
        logger.debug("get all discussion with article " + articleId + " , user " + userId + " , page " + page + " and size " + size);
        PageRequest request = new PageRequest(page - 1, size);
        return discussionService.findByUserAndArticle(articleId, userId, request);
    }

    @RequestMapping(value = "/{articleId}/discussion/id/{discussionId}", method = RequestMethod.GET)
    public Discussion findById(@PathVariable Long articleId, @PathVariable Long discussionId) {
        logger.debug("get discussion with article " + articleId + " and discussion " + discussionId);
        return discussionService.findById(discussionId);
    }

    @RequestMapping(value = "/{articleId}/discussion", method = RequestMethod.POST)
    public Discussion save(@PathVariable Long articleId, @RequestBody DiscussionDto discussion) {
        logger.debug("post discussion with article " + articleId);
        return discussionService.create(discussion);
    }

    @RequestMapping(value = "{articleId}/discussion/del/{discussionId}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long articleId, @PathVariable Long discussionId) {
        logger.debug("delete discussion with article " + articleId + " and discussion " + discussionId);
        discussionService.delById(discussionId);
    }

    @RequestMapping(value = "/{articleId}/discussion/edit/{discussionId}", method = RequestMethod.PUT)
    public Discussion update(@PathVariable Long articleId, @PathVariable Long discussionId, @RequestBody DiscussionDto discussion) {
        logger.debug("update discussion with article " + articleId + " , discussion " + discussionId);
        return discussionService.create(discussion);
    }

    @RequestMapping(value = "/discussion/new", method = RequestMethod.GET)
    public Discussion newDiscussion() {
        return new Discussion();
    }
}
