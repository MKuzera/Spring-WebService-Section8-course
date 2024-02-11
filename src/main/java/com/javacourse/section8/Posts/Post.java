package com.javacourse.section8.Posts;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.javacourse.section8.User.User;
import jakarta.persistence.*;

import java.time.LocalDate;
@Entity
public class Post {
    @Id
    private Integer id;
    private String title;
    private String description;
    private LocalDate dateAdded;
    private Integer addedByUser;
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private User user;

    public Integer getAddedByUser() {
        return addedByUser;
    }

    public void setAddedByUser(Integer addedByUser) {
        this.addedByUser = addedByUser;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(LocalDate dateAdded) {
        this.dateAdded = dateAdded;
    }

    public Post() {
    }

    public Post(Integer id, String title, String description, LocalDate dateAdded, Integer addedByUser) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.dateAdded = dateAdded;
        this.addedByUser = addedByUser;
    }
}
