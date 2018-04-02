package com.mp.onlinestore.model;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class Users {
    @Id
    @GeneratedValue( strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name="username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "active")
    private int active;

    public int getUserId() {
        return id;
    }

    public void setUserId(int userId) {
        this.id = userId;
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

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public Users(int userId, String username, String password, int active) {
        this.id = userId;
        this.username=username;
        this.password = password;
        this.active = active;
    }

    public Users() {}
}
