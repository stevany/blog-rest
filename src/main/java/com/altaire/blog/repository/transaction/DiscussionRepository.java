package com.altaire.blog.repository.transaction;

import com.altaire.blog.model.master.User;
import com.altaire.blog.model.transaction.Article;
import com.altaire.blog.model.transaction.Discussion;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by cue on 3/10/2017.
 */
public interface DiscussionRepository extends JpaRepository<Discussion, Long> {
    Page<Discussion> findByUsersOrderByIdDesc(User user, Pageable pageable);

    Page<Discussion> findByUsersAndArticlesOrderByIdDesc(User users, Article articles, Pageable pageable);

    Page<Discussion> findByArticlesOrderByIdDesc(Article articles, Pageable pageable);

    @Modifying
    @Transactional
    @Query("delete from Discussion d where d.articles=:articles ")
    void delByArticles(@Param("articles") Article articles);
}
