package com.example.demo.hexagonal_architecture.core.enitity;

public abstract class Game {
    private String title;
    private int points;

    public boolean handleAnswer(Player player, String answer) {

        return true;
    }
}
