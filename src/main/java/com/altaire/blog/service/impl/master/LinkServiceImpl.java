package com.altaire.blog.service.impl.master;

import com.altaire.blog.model.master.Link;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.altaire.blog.repository.master.LinkRepository;
import com.altaire.blog.service.master.LinkService;

import java.util.List;

/**
 * Created by cue on 3/10/2017.
 */
@Service
public class LinkServiceImpl implements LinkService {
    @Autowired
    private LinkRepository linkRepository;

    @Override
    public Link create(Link link) {
        return linkRepository.saveAndFlush(link);
    }

    @Override
    public Link findById(Long id) {
        return linkRepository.findOne(id);
    }

    @Override
    public void delById(Long id) {
        linkRepository.delete(id);
    }

    @Override
    public List<Link> findAll() {
        return linkRepository.findAll();
    }

    @Override
    public List<Link> findByName(String name) {
        return linkRepository.findByNameLike(name);
    }
}
