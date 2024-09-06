package io.github.chiangkaishek327.jge.graphics;

import javafx.geometry.Point2D;

public class MathUtil {
    public static Point2D getRotatedPoint(Point2D target, double angle) {
        double cosAngle = Math.cos(angle), sinAngle = Math.sin(angle);
        double rotatedX = (target.getX() * cosAngle) - (target.getY() * sinAngle);
        double rotatedY = (target.getX() * sinAngle) + (target.getY() * cosAngle);
        Point2D point2d = new Point2D(rotatedX, rotatedY);

        return point2d;
    }

    public static Point2D getRotatedPoint(Point2D target, double angle, Point2D origin) {
        return toAbsolutePoint(origin, getRotatedPoint(target, angle));
    }

    public static Point2D toAbsolutePoint(Point2D origin, Point2D relative) {
        return new Point2D(origin.getX() + relative.getX(), origin.getY() + relative.getY());
    }

    public static Point2D toRelativePoint(Point2D origin, Point2D relative) {
        return new Point2D(origin.getX() - relative.getX(), origin.getY() - relative.getY());
    }
}
