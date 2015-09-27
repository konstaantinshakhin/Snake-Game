package ru.shakhin.snake.view;

import ru.shakhin.snake.model.*;

import javax.swing.*;

/**
 * Created by Kostya on 01.01.2015.
 */
public class SnakeView  extends  JFrame {

   private  SnakePanel snakePanel;

    public SnakeView(SnakeGameModel gameModel){
        setSnakePanel(new SnakePanel(gameModel));
        add(getSnakePanel());

        setResizable(false);
        pack();

        setTitle("Snake");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    public SnakePanel getSnakePanel() {
        return snakePanel;
    }

    public void setSnakePanel(SnakePanel snakePanel) {
        this.snakePanel = snakePanel;
    }
}
