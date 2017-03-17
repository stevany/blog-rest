package com.altaire.blog.repository.master;

import com.altaire.blog.model.master.Link;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by cue on 3/10/2017.
 */
public interface LinkRepository extends JpaRepository<Link,Long>{
    List<Link> findByNameLike(String name);

}
