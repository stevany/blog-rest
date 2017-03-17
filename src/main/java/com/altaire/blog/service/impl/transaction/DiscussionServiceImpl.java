package com.altaire.blog.service.impl.transaction;

import com.altaire.blog.model.dto.DiscussionDto;
import com.altaire.blog.model.transaction.Discussion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.altaire.blog.repository.master.UserRepository;
import com.altaire.blog.repository.transaction.ArticleRepository;
import com.altaire.blog.repository.transaction.DiscussionRepository;
import com.altaire.blog.service.transaction.DiscussionService;

/**
 * Created by cue on 3/10/2017.
 */
@Service
public class DiscussionServiceImpl implements DiscussionService {
    @Autowired
    private DiscussionRepository discussionRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ArticleRepository articleRepository;

    @Override
    public Discussion create(Discussion discussion) {
        return discussionRepository.saveAndFlush(discussion);
    }

    @Override
    public Discussion create(DiscussionDto discussion) {
        Discussion d = new Discussion();
        d.setArticles(articleRepository.findOne(discussion.getArticleId()));
        d.setContent(discussion.getContent());
        d.setDateCreated(discussion.getDateCreated());
        d.setUsers(userRepository.findOne(discussion.getUserId()));

        return create(d);
    }


    @Override
    public Discussion findById(Long id) {
        return discussionRepository.findOne(id);
    }

    @Override
    public void delById(Long id) {
        discussionRepository.delete(id);
    }

    @Override
    public Page<Discussion> findByArticle(Long articleId, Pageable p) {
        return discussionRepository.findByArticlesOrderByIdDesc(articleRepository.findOne(articleId), p);
    }

    @Override
    public Page<Discussion> findByUser(Long userId, Pageable p) {
        return discussionRepository.findByUsersOrderByIdDesc(userRepository.findOne(userId), p);
    }

    @Override
    public Page<Discussion> findByUserAndArticle(Long userId, Long articleId, Pageable p) {

        return discussionRepository.findByUsersAndArticlesOrderByIdDesc(userRepository.findOne(userId), articleRepository.findOne(articleId), p);
    }
}
