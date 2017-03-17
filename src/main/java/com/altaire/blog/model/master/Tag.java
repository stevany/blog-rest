package com.altaire.blog.model.master;

import com.altaire.blog.model.transaction.Article;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by cue on 3/10/2017.
 */
@Entity
@Table(name = "tag")
public class Tag {

    private Long id;
    private String name;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
