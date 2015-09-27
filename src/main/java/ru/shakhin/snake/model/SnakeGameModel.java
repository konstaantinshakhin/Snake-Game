package ru.shakhin.snake.model;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Kostya on 05.01.2015.
 */
public class SnakeGameModel {
    final static public int length = 300;
    final static public int width = 300;
    private Apple apple;
    private List<Body> bodyList;
    private Direction direction ;
    public boolean playGame = true;

    public SnakeGameModel(){

        Body body0 = new Body();
        body0.setX(length/2);
        body0.setY(width/2);
        Body body1 = new Body();
        body1.setX(length/2);
        body1.setY(width/2-18);
        setDirection(Direction.NORTH);
        bodyList = new LinkedList<Body>();
        bodyList.add(body0);
        //bodyList.add(body1);
        apple = getNewApple();

    }

    public Apple getNewApple() {
        Apple apple = new Apple();
        apple.setX((int) (Math.random() * length*0.7));
        apple.setY((int) (Math.random() * width*0.7));
        //this.apple=apple;
        return apple;
    }

    public Apple getApple() {
        return apple;
    }

    public void setApple(Apple apple) {
        this.apple = apple;

    }
    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        switch (direction){
            case WEST:
                if(Direction.EAST.equals(this.direction)){
                    break;
                }
                this.direction = Direction.WEST;
                break;
            case NORTH:
                if(Direction.SOUTH.equals(this.direction)){
                    break;
                }
                this.direction = Direction.NORTH;
                break;
            case EAST:
                if(Direction.WEST.equals(this.direction)){
                    break;
                }
                this.direction = Direction.EAST;
                break;
            case SOUTH:
                if(Direction.NORTH.equals(this.direction)){
                    break;
                }
                this.direction = Direction.SOUTH;
                break;
        }
        //this.direction = direction;
    }

    public List<Body> getBody() {
        return bodyList;
    }

    public void movie() {

        for (int i = bodyList.size()-1; i >= 0; i--) {
            if (i == 0) {
                switch (getDirection()) {
                    case WEST:
                        bodyList.get(0).setX(bodyList.get(0).getX() - 1);
                        bodyList.get(0).setY(bodyList.get(0).getY());
                        break;
                    case SOUTH:
                        bodyList.get(0).setY(bodyList.get(0).getY() + 1);
                        bodyList.get(0).setX(bodyList.get(0).getX());
                        break;
                    case EAST:
                        bodyList.get(0).setX(bodyList.get(0).getX() + 1);
                        bodyList.get(0).setY(bodyList.get(0).getY());
                        break;
                    case NORTH:
                        bodyList.get(0).setY(bodyList.get(0).getY() - 1);
                        bodyList.get(0).setX(bodyList.get(0).getX());
                }

            } else {
                bodyList.get(i).setX(bodyList.get(i - 1).getX());
                bodyList.get(i).setY(bodyList.get(i - 1).getY());
            }
        }

    }

    public boolean eatApple() {
        if(Math.abs(bodyList.get(0).getX() - apple.getX())< 7 & Math.abs(bodyList.get(0).getY() - apple.getY())< 7) {
            bodyList.add(new Body());
            movie();
            bodyList.add(new Body());
            movie();
            bodyList.add(new Body());
            movie();
            bodyList.add(new Body());
            movie();
            bodyList.add(new Body());
            movie();
            bodyList.add(new Body());
            movie();
            bodyList.add(new Body());
            movie();
            return true;
        }
        return  false;
    }

    private boolean hasCollaps() {
        for (int i= 1;i< bodyList.size();i++) {
            if (bodyList.get(i).equals(bodyList.get(0))) {
                //playGame = false;
                return true;
            }
        }
        return false;

    }

    private boolean hasCickWall() {
        for (Body body : bodyList) {
            if (bodyList.get(0).getX() > length || bodyList.get(0).getX() < 0
                    || bodyList.get(0).getY() > width || bodyList.get(0).getY() < 0) {
                return true;
            }

        }
        return false;
    }

    public boolean hasGameOver(){
        if(hasCickWall()||hasCollaps()){
            playGame = false;
            return  true;
        }
        return false;
    }


}
