package ru.sandbox;

/**
 * Created by Naum.Ginzburg on 01.05.2017.
 */
public class Square {

    public double l;

    public Square(double len) {
        this.l = len;
    }

    public double area() {
        return this.l * this.l;
    }

}
