package com.altaire.blog.service.transaction;

import com.altaire.blog.model.dto.ArticleDto;
import com.altaire.blog.model.transaction.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.Date;

/**
 * Created by cue on 3/10/2017.
 */
public interface ArticleService {
    Article create(Article article);

    void delById(Long id);

    Article findById(Long id);

    ArticleDto findByDtoId(Long id);

    ArticleDto cloneTo(Article a);

    Article cloneValueFrom(ArticleDto dto, Integer action);

    Page<Article> findByUserAndName(Long userId, String name, Pageable p);

    Page<Article> findByUserAndDateCreated(Long userId, Date dateCreated, Pageable p);

    Page<Article> findByUserAndCategory(Long userId, Long categoryId, Pageable p);

    Page<Article> findByUserAndTag(Long userId, Long tagId, Pageable p);

    Page<Article> findByUser(Long userId, Pageable p);

    Page<Article> findByName(String name, Pageable p);

    Page<Article> findByDateCreated(Date from, Date to, Pageable p);

    Page<Article> findByNameAndDateCreated(String name, Date from, Date to, Pageable p);

    Page<Article> findByCategory(Long categoryId, Pageable p);

    Page<Article> findByTag(Long tagId, Pageable p);

    Page<Article> findAll(Pageable p);


}
