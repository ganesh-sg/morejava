package com.ganesh.learn.more.java;

public class ColorPoint extends Point {
    private int color;

    public ColorPoint(int x, int y, int color) {
        super(x, y);
        this.color = color;
    }

    @Override
    public boolean equals(Object object) { //TODO: How does it break symmetry
        return (object instanceof ColorPoint) && super.equals(object) && (((ColorPoint) object).color == this.color);
    }

    public static void main(String[] args) {
        Point point = new Point(1, 2);
        ColorPoint cp = new ColorPoint(1,2,3);
        System.out.println(cp.equals(point) + " " + point.equals(cp));
    }
}
