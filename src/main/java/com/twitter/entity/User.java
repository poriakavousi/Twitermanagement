package com.twitter.entity;

import com.twitter.base.domain.BaseEntity;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
@Entity
public class User extends BaseEntity<Long> {
    private String username;
    private String password;
      @ManyToMany
    private List<User> following=new ArrayList<>();//دنبال شوندگان

    public User() {
    }

    public User(String username, String password,  List<User> following) {
        this.username = username;
        this.password = password;
        this.following = following;
    }

    public User(Long aLong, String username, String password, List<User> following) {
        super(aLong);
        this.username = username;
        this.password = password;
        this.following = following;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



    public List<User> getFollowing() {
        return following;
    }

    public void setFollowing(List<User> following) {
        this.following = following;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", following=" + following +
                '}';
    }
}
