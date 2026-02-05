package com.twitter.entity;

import com.twitter.base.domain.BaseEntity;

import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.*;

@Entity
public class Twitt extends BaseEntity<Long> {
    private String twittContent;
    private Date twittDate;
    @ManyToOne
    private User user;
    private Long likeTwitt;
    @ManyToMany
    private List<User> likedTwitt =new ArrayList<>();

    public Twitt() {
    }

    public Twitt(String twittContent, Date twittDate, User user, Long likeTwitt, List<User> likedTwitt) {
        this.twittContent = twittContent;
        this.twittDate = twittDate;
        this.user = user;
        this.likeTwitt = likeTwitt;
        this.likedTwitt = likedTwitt;
    }

    public Twitt(Long aLong, String twittContent, Date twittDate, User user, Long likeTwitt, List<User> likedTwitt) {
        super(aLong);
        this.twittContent = twittContent;
        this.twittDate = twittDate;
        this.user = user;
        this.likeTwitt = likeTwitt;
        this.likedTwitt = likedTwitt;
    }

    public String getTwittContent() {
        return twittContent;
    }

    public void setTwittContent(String twittContent) {
        this.twittContent = twittContent;
    }

    public Date getTwittDate() {
        return twittDate;
    }

    public void setTwittDate(Date twittDate) {
        this.twittDate = twittDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getLikeTwitt() {
        return likeTwitt;
    }

    public void setLikeTwitt(Long likeTwitt) {
        this.likeTwitt = likeTwitt;
    }

    public List<User> getLikedTwitt() {
        return likedTwitt;
    }

    public void setLikedTwitt(List<User> likedTwitt) {
        this.likedTwitt = likedTwitt;
    }

    @Override
    public String toString() {
        return "Twitt{" +
                "twittContent='" + twittContent + '\'' +
                ", twittDate=" + twittDate +
                ", user=" + user +
                ", likeTwitt=" + likeTwitt +
                ", likedTwitt=" + likedTwitt +
                '}';
    }
}
