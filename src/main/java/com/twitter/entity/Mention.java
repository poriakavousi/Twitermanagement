package com.twitter.entity;

import com.twitter.base.domain.BaseEntity;
import javax.persistence.ManyToOne;

import javax.persistence.Entity;
import java.util.Date;
@Entity
public class Mention extends BaseEntity<Long> {
    private String mentionContent;
    private Date mentionDate;
    @ManyToOne
    private Twitt twitt;

    public Mention() {
    }

    public Mention(String mentionContent, Date mentionDate, Twitt twitt) {
        this.mentionContent = mentionContent;
        this.mentionDate = mentionDate;
        this.twitt = twitt;
    }

    public Mention(Long aLong, String mentionContent, Date mentionDate, Twitt twitt) {
        super(aLong);
        this.mentionContent = mentionContent;
        this.mentionDate = mentionDate;
        this.twitt = twitt;
    }

    public String getMentionContent() {
        return mentionContent;
    }

    public void setMentionContent(String mentionContent) {
        this.mentionContent = mentionContent;
    }

    public Date getMentionDate() {
        return mentionDate;
    }

    public void setMentionDate(Date mentionDate) {
        this.mentionDate = mentionDate;
    }

    public Twitt getTwitt() {
        return twitt;
    }

    public void setTwitt(Twitt twitt) {
        this.twitt = twitt;
    }

    @Override
    public String toString() {
        return "Mention{" +
                "mentionContent='" + mentionContent + '\'' +
                ", mentionDate=" + mentionDate +
                ", twitt=" + twitt +
                '}';
    }
}
