package com.altaire.blog.model.transaction;

import com.altaire.blog.model.master.Category;
import com.altaire.blog.model.master.Tag;
import com.altaire.blog.model.master.User;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * Created by cue on 3/10/2017.
 */
@Entity
@Table(name = "article")
public class Article {

    private Long id;
    private String name;
    private String content;
    private String slug;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateUpdate;
    private User userCreated;
    private User userUpdate;
    private Category category;

    private Set<Tag> tags;

    public Article() {
    }

    @ManyToOne
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getDateUpdate() {
        return dateUpdate;
    }

    public void setDateUpdate(Date dateUpdate) {
        this.dateUpdate = dateUpdate;
    }

    @ManyToOne
    public User getUserCreated() {
        return userCreated;
    }

    public void setUserCreated(User userCreated) {
        this.userCreated = userCreated;
    }

    @ManyToOne
    public User getUserUpdate() {
        return userUpdate;
    }

    public void setUserUpdate(User userUpdate) {
        this.userUpdate = userUpdate;
    }

    @ManyToMany()
    @JoinTable(name = "article_tag", joinColumns = @JoinColumn(name = "article_id"), inverseJoinColumns = @JoinColumn(name = "tag_id"))
    public Set<Tag> getTags() {
        return tags;
    }


    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }
}
