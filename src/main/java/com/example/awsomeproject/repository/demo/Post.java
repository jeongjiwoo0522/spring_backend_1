package com.example.awsomeproject.repository.demo;

import javax.persistence.Column;
import javax.persistence.Id;
import java.time.LocalDateTime;

public class Post {

    @Id
    private String id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @Column
    private LocalDateTime createdAt;
}
