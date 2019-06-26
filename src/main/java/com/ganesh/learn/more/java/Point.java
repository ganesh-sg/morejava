package com.ganesh.learn.more.java;

public class Point {

    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Point anotherPoint = (Point) obj;
        return anotherPoint.x == this.x && anotherPoint.y == this.y;
    }
}
