package ru.shakhin.snake.view;

import ru.shakhin.snake.model.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;

/**
 * Created by Kostya on 02.01.2015.
 */
public class SnakePanel extends JPanel implements ActionListener {

    private Image imageBody;
    private Image imageApple;
    private Image imageHead;
    private SnakeGameModel gameModel;
    private List<Body> bodyList;
    private final int DELAY = 140;
    private Timer timer;

    private Apple apple;
    private String msg ="Hello World!!!";


    public SnakePanel(SnakeGameModel gameModel){
        this.gameModel = gameModel;
        addKeyListener(new TAdapter());
        setBackground(Color.black);
        setFocusable(true);
        setPreferredSize(new Dimension(gameModel.width, gameModel.length));
//        timer = new Timer(DELAY, this);
//        timer.start();

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if(!gameModel.hasGameOver()) {
            doDrawing(g);
        }
        else{
            gameOver(g);
        }
    }

    private void drawGreenCircle(Graphics g,int r,int x,int y){
        Color oldColor = g.getColor();
        Color grColor = new Color(0, 255, 0);
        g.setColor(grColor);
        g.fillOval(x, y, r,r);
        g.setColor(oldColor);
    }
    private void drawRedCircle(Graphics g,int r,int x,int y){
        Color oldColor = g.getColor();
        Color grColor = new Color(255,0 , 0);
        g.setColor(grColor);
        g.fillOval(x, y, r,r);
        g.setColor(oldColor);
    }

    public void updateBody(){
        bodyList= gameModel.getBody();
    }

    public void updateApple(){
        apple = gameModel.getApple();
    }

    private void doDrawing(Graphics g) {
        updateApple();
        updateBody();

        drawRedCircle(g,11,apple.getX(),apple.getY());

        for(int z = 0;z<bodyList.size();z++) {
           drawGreenCircle(g,13,bodyList.get(z).getX(),bodyList.get(z).getY());
        }

        Toolkit.getDefaultToolkit().sync();

    }

    private void gameOver(Graphics g) {

        String msg = "Game Over";
        Font small = new Font("Helvetica", Font.BOLD, 14);
        FontMetrics metr = getFontMetrics(small);

        g.setColor(Color.white);
        g.setFont(small);
        g.drawString(msg, (gameModel.width - metr.stringWidth(msg)) / 2, gameModel.length / 2);
    }

    private void printMessage(Graphics g,String msg){
        Font small = new Font("Helvetica", Font.BOLD, 14);
        FontMetrics metr = getFontMetrics(small);

        g.setColor(Color.white);
        g.setFont(small);
        g.drawString(msg,gameModel.width - metr.stringWidth(msg)/2,gameModel.width);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
       repaint();
    }

    private class TAdapter extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {



            int key = e.getKeyCode();

            if (key == KeyEvent.VK_LEFT) {
                System.out.println("LEFT");
                msg = "LEFT";
                gameModel.setDirection(Direction.WEST);

            }

            if (key == KeyEvent.VK_RIGHT) {
                System.out.println("RIGHT");
                msg = "RIGHT";
                gameModel.setDirection(Direction.EAST);

            }

            if (key == KeyEvent.VK_UP) {
                System.out.println("UP");
                msg = "UP";
                gameModel.setDirection(Direction.NORTH);
            }

            if (key == KeyEvent.VK_DOWN) {
                System.out.println("DOWN");
                msg = "DOWN";
                gameModel.setDirection(Direction.SOUTH);
            }


        }
    }


}
