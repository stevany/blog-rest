package com.altaire.blog.service.master;

import com.altaire.blog.model.master.Tag;

import java.util.List;

/**
 * Created by cue on 3/10/2017.
 */
public interface TagService {
    Tag create(Tag tag);

    Tag findById(Long id);

    void delById(Long id);

    List<Tag> findAll();

    List<Tag> findByName(String name);
}
