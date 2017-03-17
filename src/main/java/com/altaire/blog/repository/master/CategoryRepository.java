package com.altaire.blog.repository.master;

import com.altaire.blog.model.master.Category;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by cue on 3/10/2017.
 */
public interface CategoryRepository extends JpaRepository <Category, Long> {
    List<Category> findByNameLike(String name);

    @Query("select c from Category c where name like :name% ")
    Page<Category> findByNameLike(@Param("name") String name, Pageable pageable);

}
