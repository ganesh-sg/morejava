package com.ganesh.learn.more.java;

import java.util.HashSet;
import java.util.Set;

public class PointCircle {
    Set<Point> circlePoints = new HashSet<>();

    public PointCircle() {
        this.circlePoints.add(new Point(1, 0));
        this.circlePoints.add(new Point(-1, 0));
        this.circlePoints.add(new Point(0, 1));
        this.circlePoints.add(new Point(0, -1));
    }

    public boolean isOnCircle(Point point) {
        return circlePoints.contains(point);
    }

    public static void main(String[] args) {
        ColorPoint colorPoint = new ColorPoint(1, 0, 1);
        PointCircle pointCircle = new PointCircle();
        System.out.println(pointCircle.isOnCircle(colorPoint));
    }
}
