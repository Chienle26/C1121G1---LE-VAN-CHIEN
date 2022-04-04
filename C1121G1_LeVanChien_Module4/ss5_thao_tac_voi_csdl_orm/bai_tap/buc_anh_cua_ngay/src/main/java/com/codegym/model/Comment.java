package com.codegym.model;

import com.mysql.cj.protocol.ColumnDefinition;

import javax.persistence.*;

@Entity(name = "comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String author;
    private String feedback;
    private Integer points;
    private Integer likes;
    @Column(columnDefinition = "date")
    private String dates;

    public Comment() {
    }

    public Comment(Integer id, String author, String feedback, Integer points, Integer likes, String dates) {
        this.id = id;
        this.author = author;
        this.feedback = feedback;
        this.points = points;
        this.likes = likes;
        this.dates = dates;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public String getDates() {
        return dates;
    }

    public void setDates(String dates) {
        this.dates = dates;
    }
}
