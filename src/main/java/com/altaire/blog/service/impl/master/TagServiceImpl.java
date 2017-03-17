package com.altaire.blog.service.impl.master;

import com.altaire.blog.model.master.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.altaire.blog.repository.master.TagRepository;
import com.altaire.blog.service.master.TagService;

import java.util.List;

/**
 * Created by cue on 3/10/2017.
 */
@Service
public class TagServiceImpl implements TagService {
    @Autowired
    private TagRepository tagRepository;

    @Override
    public Tag create(Tag tag) {
        return tagRepository.saveAndFlush(tag);
    }

    @Override
    public Tag findById(Long id) {
        return tagRepository.findOne(id);
    }

    @Override
    public void delById(Long id) {
        tagRepository.delete(id);
    }

    @Override
    public List<Tag> findAll() {
        return tagRepository.findAll();
    }

    @Override
    public List<Tag> findByName(String name) {
        return tagRepository.findByNameLike(name);
    }
}
