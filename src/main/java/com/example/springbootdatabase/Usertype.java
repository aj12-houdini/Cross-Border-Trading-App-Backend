package com.example.springbootdatabase;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usertypes")
public class Usertype {
    @Id
    @Column(name = "id", nullable = false, length = 10)
    private String id;

    @Column(name = "username", length = 50)
    private String username;

    @Column(name = "type", length = 50)
    private String type;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}