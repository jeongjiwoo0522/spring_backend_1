package com.example.awsomeproject.domain;

import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity()
public class User {

    @Id
    @Type(type = "uuid-char")
    @GeneratedValue
    private UUID id;

    @Column(length = 50)
    private String name;

    @Column
    private String password;

    @OneToMany()
    private List<Post> post;
}
