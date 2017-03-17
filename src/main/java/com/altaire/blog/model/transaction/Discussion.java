package com.altaire.blog.model.transaction;

import com.altaire.blog.model.master.User;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by cue on 3/10/2017.
 */
@Entity
@Table(name = "discussion")
public class Discussion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private User users;
    @ManyToOne
    private Article articles;
    private String content;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated;

    public Discussion() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUsers() {
        return users;
    }

    public void setUsers(User users) {
        this.users = users;
    }

    public Article getArticles() {
        return articles;
    }

    public void setArticles(Article articles) {
        this.articles = articles;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }
}
