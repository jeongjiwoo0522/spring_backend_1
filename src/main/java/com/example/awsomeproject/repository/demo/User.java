package com.example.awsomeproject.repository.demo;

import javax.persistence.*;

@Entity
public class User {

    @Id
    private String id;

    @Column(length = 50)
    private String name;

    @Column
    private String password;

    @Column(name = "is_admin")
    private String isAdmin;
}
