package io.github.chiangkaishek327.jge.object;

import java.util.ArrayList;
import java.util.List;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Point2D;

public class BoundBox {
    ObservableList<Point2D> relativeBoundPoints = FXCollections.observableArrayList();
    DoubleProperty rotation = new SimpleDoubleProperty(0);
    DoubleProperty locationX = new SimpleDoubleProperty(0);
    DoubleProperty locationY = new SimpleDoubleProperty(0);
    DoubleProperty scaleX = new SimpleDoubleProperty(0);
    DoubleProperty scaleY = new SimpleDoubleProperty(0);
    Point2D location = new Point2D(0, 0);

    public BoundBox() {

    }
}
