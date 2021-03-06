package com.codecool.snake;

import com.codecool.snake.buttons.RestartButton;
import com.codecool.snake.entities.enemies.Crocodille;
import com.codecool.snake.entities.enemies.SimpleEnemy;
import com.codecool.snake.entities.powerups.AddHP;
import com.codecool.snake.entities.powerups.Coffee;
import com.codecool.snake.entities.enemies.Bomb;
import com.codecool.snake.entities.powerups.SimplePowerUp;
import com.codecool.snake.entities.snakes.Snake;
import com.codecool.snake.eventhandler.InputHandler;

import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;



public class Game extends Pane {
    private Snake snake = null;
    private GameTimer gameTimer = new GameTimer();



    public Game() {
        Globals.getInstance().game = this;
        Globals.getInstance().display = new Display(this);
        Globals.getInstance().setupResources();
        init();
    }

    public void init() {
        spawnSnake();
        spawnEnemies(4);
        spawnPowerUps(4);
        spawnCoffee(2);
        addRestartButton();

        GameLoop gameLoop = new GameLoop(snake);
        Globals.getInstance().setGameLoop(gameLoop);
        gameTimer.setup(gameLoop::step);
        gameTimer.play();
    }

    public void start() {
        this.requestFocus();
        setupInputHandling();
        Globals.getInstance().startGame();
    }

    private void addRestartButton(){
        RestartButton restartButton = new RestartButton();
        Globals.getInstance().display.add(restartButton.getRestartButton());
    }

    private void spawnSnake() {
        snake = new Snake(new Point2D(500, 500));
    }

    private void spawnEnemies(int numberOfEnemies) {
        for(int i = 0; i < numberOfEnemies; ++i) new SimpleEnemy();
        for(int i = 0; i < numberOfEnemies-2; ++i) new Bomb();
        for(int i = 0; i < numberOfEnemies-3; ++i) new Crocodille();
    }

    private void spawnPowerUps(int numberOfPowerUps) {
        for(int i = 0; i < numberOfPowerUps; ++i) new SimplePowerUp();
        for(int i = 0; i < numberOfPowerUps; ++i) new AddHP();
    }

    private void spawnCoffee(int numberOfCoffee){
        for(int i = 0; i < numberOfCoffee; ++i) new Coffee();
    }

    private void setupInputHandling() {
        Scene scene = getScene();
        scene.setOnKeyPressed(event -> InputHandler.getInstance().setKeyPressed(event.getCode()));
        scene.setOnKeyReleased(event -> InputHandler.getInstance().setKeyReleased(event.getCode()));
    }

    int getBody(){
        return snake.getBody();
    }
    int getHealth() {return snake.getHealth();}
}
