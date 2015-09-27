package ru.shakhin.snake.controller;

import ru.shakhin.snake.model.SnakeGameModel;

import ru.shakhin.snake.view.SnakePanel;
import ru.shakhin.snake.view.SnakeView;

/**
 * Created by Kostya on 27.12.2014.
 */
public class GameController {

    private SnakeGameModel gameModel;
    private SnakeView gameView;
    private boolean GameOver;
    SnakePanel snakePanel;

    public void playGame(){
        gameModel = new SnakeGameModel();
        gameView = new SnakeView(gameModel);
       snakePanel = gameView.getSnakePanel();
        gameView.setVisible(true);
        while(!gameModel.hasGameOver()){
            snakePanel.actionPerformed(null);
            gameModel.movie();
            try {
                Thread.sleep(21);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(gameModel.eatApple()){
                gameModel.setApple(gameModel.getNewApple());
            }
        }
    }

public static void main(String[] args){
    new GameController().playGame();
    }
}
