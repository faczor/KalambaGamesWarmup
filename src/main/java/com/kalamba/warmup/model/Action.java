package com.kalamba.warmup.model;

import javax.persistence.*;

@Entity
public class Action {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ActionId", nullable = false)
    private Integer actionId;

    @Column(name = "Action", nullable = false)
    private String action;

    @JoinColumn(name = "UserId")
    @ManyToOne
    private User user;

    @JoinColumn(name = "GameId")
    @ManyToOne
    private Game game;

    public Action(String action, User user, Game game) {
        this.action = action;
        this.user = user;
        this.game = game;
    }
}
