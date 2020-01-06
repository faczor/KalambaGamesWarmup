package com.kalamba.warmup.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "UserId", nullable = false)
    private Integer userId;

    @Column(name = "Name", nullable = false)
    private String name;

    @OneToMany(mappedBy = "user")
    private Set<Action> action;
}
