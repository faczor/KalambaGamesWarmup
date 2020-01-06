package com.kalamba.warmup.model;

public class NewActionDto {
    private Integer gameId;
    private Integer userId;
    private String action;

    public NewActionDto(Integer gameId, Integer userId, String action) {
        this.gameId = gameId;
        this.userId = userId;
        this.action = action;
    }

    public Integer getGameId() {
        return gameId;
    }

    public void setGameId(Integer gameId) {
        this.gameId = gameId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
}
