package com.ganesh.learn.more.java;

import java.awt.*;

public class ColorDelegatePoint {
    private Point point;
    private Color color;

    public ColorDelegatePoint() {
    }

    public ColorDelegatePoint(Point point, Color color) {
        this.point = point;
        this.color = color;
    }

    public Point asPoint() {
        return point;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof ColorDelegatePoint)) {
            return false;
        }

        ColorDelegatePoint colorObj = (ColorDelegatePoint) object;
        return colorObj.color== this.color && colorObj.point.equals(this.point);
    }
}
