package model;

import java.util.Objects;

public class Car implements Vehicle{
    private final String color;
    private final String name;

    public Car(String color,String name){
        this.color=color;
        this.name=name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public boolean isRed() {
        return Objects.equals(this.color, "red");
    }

    @Override
    public String toString(){
        return "The " + name +" Car is " +color;
    }
}
