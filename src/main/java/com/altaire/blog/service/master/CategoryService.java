package com.altaire.blog.service.master;

import com.altaire.blog.model.master.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by cue on 3/10/2017.
 */
public interface CategoryService {
    Category create(Category category);

    Category findById(Long id);

    void delById(Long id);

    List<Category> findAll();

    Page<Category> findAll(Pageable p);

    List<Category> findByName(String name);

    Page<Category> findByName(String name, Pageable p);

}
