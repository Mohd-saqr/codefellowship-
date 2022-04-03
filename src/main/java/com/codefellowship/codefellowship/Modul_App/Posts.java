package com.codefellowship.codefellowship.Modul_App;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;


@Entity
public class Posts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String body;
    @Column
    @CreationTimestamp()
    private Timestamp createdAt;
    private Long likes;

    public Long getLikes() {
        return likes;
    }

    public Posts() {
    }

    public Posts(String body) {
        this.body = body;
    }

    public void setLikes(Long likes) {
        this.likes = likes;
    }

    public Long getId() {
        return id;
    }


    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }


}
