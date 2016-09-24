package com.weatherCheck.main;

/**
 * Created by MaxPower on 23/09/2016.
 */
public class Wind {

    private int speed;
    private int direction;

    public Wind(int speed, int direction) {
        this.speed = speed;
        this.direction = direction;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    @Override
    public String toString(){
        return "Wind Speed: "+speed+
                "Wind Direction: "+direction+"º";
    }
}
