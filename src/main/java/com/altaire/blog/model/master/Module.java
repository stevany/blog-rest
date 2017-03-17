package com.altaire.blog.model.master;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by cue on 3/16/2017.
 */
@Entity
@Table(name="module")
public class Module {
    private Long id;
    private String name;

    public Module() {
    }
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
