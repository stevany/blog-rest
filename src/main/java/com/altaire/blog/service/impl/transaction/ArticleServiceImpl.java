package com.altaire.blog.service.impl.transaction;

import com.altaire.blog.model.dto.ArticleDto;
import com.altaire.blog.model.enumeration.Actions;
import com.altaire.blog.model.master.Tag;
import com.altaire.blog.model.master.User;
import com.altaire.blog.model.transaction.Article;
import com.altaire.blog.repository.transaction.DiscussionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.altaire.blog.repository.master.CategoryRepository;
import com.altaire.blog.repository.master.TagRepository;
import com.altaire.blog.repository.master.UserRepository;
import com.altaire.blog.repository.transaction.ArticleRepository;
import com.altaire.blog.service.transaction.ArticleService;


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import static com.altaire.blog.model.enumeration.Actions.valueOf;

/**
 * Created by cue on 3/10/2017.
 */
@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private TagRepository tagRepository;
    @Autowired
    private DiscussionRepository discussionRepository;

    @Override
    public Article create(Article article) {

        return articleRepository.saveAndFlush(article);
    }


    @Override
    public void delById(Long id) {
        discussionRepository.delByArticles(findById(id));
        articleRepository.delete(id);
    }

    @Override
    public Article findById(Long id) {
        return articleRepository.findOne(id);
    }

    @Override
    public ArticleDto findByDtoId(Long id) {
        return cloneTo(findById(id));
    }

    @Override
    public ArticleDto cloneTo(Article a) {
        ArticleDto dto = new ArticleDto();
        dto.setCategory(a.getCategory().getId());
        dto.setContent(a.getContent());
        dto.setDateCreated(a.getDateCreated());
        dto.setDateUpdate(a.getDateUpdate());
        dto.setId(a.getId());
        dto.setName(a.getName());
        dto.setSlug(a.getSlug());

        Long[] tags = {};
        if (a.getTags() != null) {
            tags = new Long[a.getTags().size()];
            int i = 0;
            for (Tag tag : a.getTags()) {
                tags[i] = tag.getId();
                i++;
            }
        }
        dto.setTags(tags);
        dto.setUserCreated(a.getUserCreated().getId());
        dto.setUserUpdate(a.getUserUpdate().getId());
        return dto;
    }

    @Override
    public Article cloneValueFrom(ArticleDto dto, Integer action) {
        Article a = new Article();
        a.setId(dto.getId());
        a.setCategory(categoryRepository.findOne(dto.getCategory()));
        a.setContent(dto.getContent());
        a.setName(dto.getName());

        switch (action) {
            case 0: //create
                a.setDateCreated(new Date(System.currentTimeMillis()));
                a.setDateUpdate(new Date(System.currentTimeMillis()));
                User user = userRepository.findOne(dto.getUserCreated());
                a.setUserCreated(user);
                a.setUserUpdate(user);

                break;

            case 1: //update

                a.setDateCreated(dto.getDateCreated());
                a.setDateUpdate(new Date(System.currentTimeMillis()));
                a.setUserCreated(userRepository.getOne(dto.getUserCreated()));
                a.setUserUpdate(userRepository.getOne(dto.getUserUpdate()));

                break;
        }
        if (dto.getTags() != null) {
            Set<Tag> tags = new HashSet<Tag>();
            for (Long id : dto.getTags()) {
                Tag t = new Tag();
                t.setId(id);
                tags.add(t);
            }
            a.setTags(tags);
        }
        return a;
    }

    @Override
    public Page<Article> findByUserAndName(Long userId, String name, Pageable p) {

        return articleRepository.findByUserUpdateAndNameLike(userRepository.findOne(userId), name, p);
    }

    @Override
    public Page<Article> findByUserAndDateCreated(Long userId, Date dateCreated, Pageable p) {
        return articleRepository.findByUserUpdateAndDateCreatedOrderByIdDesc(userRepository.findOne(userId), dateCreated, p);
    }

    @Override
    public Page<Article> findByUserAndCategory(Long userId, Long categoryId, Pageable p) {
        return articleRepository.findByUserUpdateAndCategoryOrderByIdDesc(userRepository.findOne(userId), categoryRepository.findOne(categoryId), p);
    }

    @Override
    public Page<Article> findByUserAndTag(Long userId, Long tagId, Pageable p) {
        return articleRepository.findByUserUpdateAndTags(userRepository.findOne(userId), tagRepository.findOne(tagId), p);
    }

    @Override
    public Page<Article> findByUser(Long userId, Pageable p) {
        return articleRepository.findByUserUpdate(userRepository.findOne(userId), p);
    }

    @Override
    public Page<Article> findByName(String name, Pageable p) {
        return articleRepository.findByNameLike(name, p);
    }

    @Override
    public Page<Article> findByDateCreated(Date from, Date to, Pageable p) {
        return articleRepository.findByDateCreatedBetweenOrderByIdDesc(from, to, p);
    }

    @Override
    public Page<Article> findByNameAndDateCreated(String name, Date from, Date to, Pageable p) {
        return articleRepository.findByNameLikeAndDateCreatedBetweenOrderByIdDesc(name, from, to, p);
    }

    @Override
    public Page<Article> findByCategory(Long categoryId, Pageable p) {
        return articleRepository.findByCategoryOrderByIdDesc(categoryRepository.findOne(categoryId), p);
    }

    @Override
    public Page<Article> findByTag(Long tagId, Pageable p) {
        return articleRepository.findByTags(tagRepository.findOne(tagId), p);
    }

    @Override
    public Page<Article> findAll(Pageable p) {
        return articleRepository.findAll(p);
    }

}