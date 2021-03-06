package com.codecool.snake;

import com.codecool.snake.buttons.RestartButton;
import com.codecool.snake.entities.GameEntity;
import java.util.List;

import javafx.scene.control.Button;
import javafx.scene.layout.Pane;


public class Display {
    public Pane displayPane;
    private DelayedModificationList<GameEntity> gameObjects = new DelayedModificationList<>();


    public Display(Pane pane) {
        displayPane = pane;
    }

    public void add(GameEntity entity) {
        displayPane.getChildren().add(entity);
        gameObjects.add(entity);
    }

    public void add(Button button){
        displayPane.getChildren().add(button);
    }
    public void remove(GameEntity entity) {
        displayPane.getChildren().remove(entity);
        gameObjects.remove(entity);
    }

    public List<GameEntity> getObjectList() {
        return gameObjects.getList();
    }

    public void frameFinished() {
        gameObjects.doPendingModifications();
    }

    public void updateSnakeHeadDrawPosition(GameEntity snakeHead) {
        displayPane.getChildren().remove(snakeHead);
        displayPane.getChildren().add(snakeHead);
    }

    public void clear() {
        displayPane.getChildren().clear();
        gameObjects.clear();
    }

}
