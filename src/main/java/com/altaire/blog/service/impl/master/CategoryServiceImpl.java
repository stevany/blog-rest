package com.altaire.blog.service.impl.master;

import com.altaire.blog.model.master.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.altaire.blog.repository.master.CategoryRepository;
import com.altaire.blog.service.master.CategoryService;

import java.util.List;

/**
 * Created by cue on 3/10/2017.
 */
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Category create(Category category) {
        return categoryRepository.saveAndFlush(category);
    }

    @Override
    public Category findById(Long id) {
        return categoryRepository.findOne(id);
    }

    @Override
    public void delById(Long id) {
        categoryRepository.delete(id);
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Page<Category> findAll(Pageable p) {
        return categoryRepository.findAll(p);
    }

    @Override
    public List<Category> findByName(String name) {
        return categoryRepository.findByNameLike(name);
    }

    @Override
    public Page<Category> findByName(String name, Pageable p) {
        return categoryRepository.findByNameLike(name, p);
    }
}
