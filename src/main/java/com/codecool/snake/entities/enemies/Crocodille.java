package com.codecool.snake.entities.enemies;

import com.codecool.snake.Globals;
import com.codecool.snake.Utils;
import com.codecool.snake.entities.Animatable;
import com.codecool.snake.entities.GameEntity;
import com.codecool.snake.entities.Interactable;
import com.codecool.snake.entities.snakes.SnakeHead;
import javafx.geometry.Point2D;

import java.util.Random;

public class Crocodille extends Enemy implements Animatable, Interactable {

    private Point2D heading;
    private static Random rnd = new Random();
    private double direction = 1 * 360;
    private int speed = 1;

    public Crocodille(){
        super(20);
        setImage(Globals.getInstance().getImage("crocodile"));
        setX(rnd.nextDouble() * Globals.WINDOW_WIDTH);
        setY(rnd.nextDouble() * Globals.WINDOW_HEIGHT);
        setRotate(direction);


    }

    @Override
    public void step() {
        if(isOutOfBounds()){
            destroy();
        }
        heading = Utils.directionToVector(direction++,speed);
        setRotate(direction+110);
        setX(getX() + heading.getX());
        setY(getY() + heading.getY());


    }

    @Override
    public void apply(GameEntity entity) {
        if(entity instanceof SnakeHead){
            System.out.println(getMessage());
            destroy();
        }

    }

    @Override
    public String getMessage() {
        return (getDamage() + " Damage");
    }
}

