package com.altaire.blog.service.master;

import com.altaire.blog.model.master.Link;

import java.util.List;

/**
 * Created by cue on 3/10/2017.
 */
public interface LinkService {
    Link create(Link link);

    Link findById(Long id);

    void delById(Long id);

    List<Link> findAll();

    List<Link> findByName(String name);
}
