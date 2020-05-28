package com.codecool.snake;

import com.codecool.snake.resources.Resources;
import javafx.scene.image.Image;

// class for holding all static stuff
public class Globals {
    private static Globals instance = null;

    public static final double WINDOW_WIDTH = 1280;
    public static final double WINDOW_HEIGHT = 720;

    public Display display;
    public Game game;

    private GameLoop gameLoop;
    private Resources resources;

    public static Globals getInstance() {
        if(instance == null) instance = new Globals();
        return instance;
    }

    public void setGameLoop(GameLoop gameLoop) {
        this.gameLoop = gameLoop;
    }

    public void setupResources() {
        resources = new Resources();
        resources.addImage("SnakeHead", new Image("snake_head.png"));
        resources.addImage("crocodile", new Image("rsz_2crocodile.png"));
        resources.addImage("SnakeBody", new Image("snake_body.png"));
        resources.addImage("SimpleEnemy", new Image("simple_enemy.png"));
        resources.addImage("PowerUpBerry", new Image("power_up_berry.png"));
        resources.addImage("AddHP", new Image("add_hp.png"));
    }

    public Image getImage(String name) { return resources.getImage(name); }

    public void startGame() { gameLoop.start(); }

    public void stopGame() {
        gameLoop.stop();
    }

    private Globals() {
        // singleton needs the class to have private constructor
    }
}
