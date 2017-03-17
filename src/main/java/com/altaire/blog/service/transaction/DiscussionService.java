package com.altaire.blog.service.transaction;

import com.altaire.blog.model.dto.DiscussionDto;
import com.altaire.blog.model.transaction.Discussion;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Created by cue on 3/10/2017.
 */
public interface DiscussionService {
    Discussion create(Discussion discussion);

    Discussion create(DiscussionDto discussion);

    Discussion findById(Long id);

    void delById(Long id);

    Page<Discussion> findByArticle(Long articleId, Pageable p);

    Page<Discussion> findByUser(Long userId, Pageable p);

    Page<Discussion> findByUserAndArticle(Long userId, Long articleId, Pageable p);
}
