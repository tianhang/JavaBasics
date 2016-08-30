package com.company;

/**
 * Created by tianhang on 29/8/2016.
 */
public class ReflectPoint {
    private int x;
    private int y;

    public ReflectPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ReflectPoint point = (ReflectPoint) o;

        if (x != point.x) return false;
        return y == point.y;

    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }

    public static void run(){
        System.out.println("static method run ...");
    }
    public int add(int z){
        return x+y+z;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}
