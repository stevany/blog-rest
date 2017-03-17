package com.altaire.blog.repository.transaction;

import com.altaire.blog.model.master.Category;
import com.altaire.blog.model.master.Tag;
import com.altaire.blog.model.master.User;
import com.altaire.blog.model.transaction.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;


/**
 * Created by cue on 3/10/2017.
 */
public interface ArticleRepository extends JpaRepository<Article, Long> {
    Page<Article> findByUserUpdateAndNameLike(User userUpdate, String name, Pageable pageable);

    Page<Article> findByUserUpdateAndDateCreatedOrderByIdDesc(User userUpdate, Date dateCreated, Pageable pageable);

    Page<Article> findByUserUpdateAndCategoryOrderByIdDesc(User userUpdate, Category category, Pageable pageable);

    Page<Article> findByUserUpdateAndTags(User userUpdate, Tag tags, Pageable pageable);

    @Query("select a from Article a where name like :name% ")
    Page<Article> findByNameLike(@Param("name") String name, Pageable p);

    Page<Article> findByDateCreatedBetweenOrderByIdDesc(Date from, Date to, Pageable pageable);

    @Query("select a from Article a where name like :name% and dateCreated between :from and :to order by id desc ")
    Page<Article> findByNameLikeAndDateCreatedBetweenOrderByIdDesc(@Param("name") String name, @Param("from") Date from, @Param("to") Date to, Pageable pageable);

    Page<Article> findByCategoryOrderByIdDesc(Category category, Pageable pageable);

    Page<Article> findByTags(Tag tags, Pageable pageable);

    Page<Article> findByUserUpdate(User userUpdate, Pageable p);

}
