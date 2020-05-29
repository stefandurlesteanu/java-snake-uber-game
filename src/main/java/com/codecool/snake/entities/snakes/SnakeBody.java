package com.codecool.snake.entities.snakes;

import com.codecool.snake.entities.GameEntity;
import com.codecool.snake.Globals;
import javafx.geometry.Point2D;

import java.util.LinkedList;
import java.util.Queue;



public class SnakeBody extends GameEntity {
    private Queue<Point2D> history = new LinkedList<>();

    public SnakeBody(Point2D coord, float historySize) {
        setImage(Globals.getInstance().getImage("SnakeBody"));
        setX(coord.getX());
        setY(coord.getY());

        for (int i = 0; i < historySize; i++) {
            history.add(coord);
        }
    }

    @Override
    public void setPosition(Point2D pos) {
        Point2D currentPos = history.poll(); // remove the oldest item from the history
        setX(currentPos.getX());
        setY(currentPos.getY());
        history.add(pos); // add the parent's current position to the beginning of the history
    }

}