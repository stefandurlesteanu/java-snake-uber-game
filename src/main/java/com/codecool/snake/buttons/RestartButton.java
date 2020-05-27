package com.codecool.snake.buttons;
import com.codecool.snake.Globals;
import javafx.scene.control.Button;


public class RestartButton{
    private Button restartButton = new Button("RESTART");


    public RestartButton(){
        restartButton.setOnAction(e -> triggerRestart());
    }

    private void triggerRestart(){
        cleanWindow();
    }
    private void cleanWindow(){
        Globals.getInstance().stopGame();
        Globals.getInstance().display.clear();
        restartGame();
    }

    private void restartGame(){
        Globals.getInstance().game.init();
        Globals.getInstance().game.start();
    }

    public Button getRestartButton(){
        return this.restartButton;
    }
}

