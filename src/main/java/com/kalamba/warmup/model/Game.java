package com.kalamba.warmup.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "GameId", nullable = false)
    private Integer gameId;

    @Column(name = "Name", nullable = false)
    private String name;

    @OneToMany(mappedBy = "game")
    private Set<Action> action;
}
