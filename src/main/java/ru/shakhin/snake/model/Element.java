package ru.shakhin.snake.model;

/**
 * Created by Kostya on 27.12.2014.
 */
public abstract class Element {
    private int x;
    private int y;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean equals(Object object){
        Element element = (Element)object;
        return (element.getX() == this.getX())&(element.getY() == this.getY());

    }
}
