package com.mp.onlinestore.model;

import javax.persistence.*;

@Entity
@Table(name = "authorities")
public class Roles {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="id")
    private int id;

    @Column(name="authority")
    private String authority;

    @Column(name="username")
    private String username;

    public int getId() {
        return id;
    }

    public void setId(int userId) {
        this.id = userId;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Roles(int userId, String authority, String username) {
        this.id = userId;
        this.authority = authority;
        this.username = username;
    }

    public Roles() {}
}
