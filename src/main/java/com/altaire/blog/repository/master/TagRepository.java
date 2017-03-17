package com.altaire.blog.repository.master;

import com.altaire.blog.model.master.Tag;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

/**
 * Created by cue on 3/10/2017.
 */
public interface TagRepository extends JpaRepository<Tag,Long> {
    List<Tag> findByNameLike(String name);
}
