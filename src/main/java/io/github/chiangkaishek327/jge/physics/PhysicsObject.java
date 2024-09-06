package io.github.chiangkaishek327.jge.physics;

import io.github.chiangkaishek327.jge.object.BoundBox;
import javafx.beans.property.DoubleProperty;

public interface PhysicsObject {
    public BoundBox getBoundBox();

    public double getWeight();

    public void setWeight(double weight);

    public DoubleProperty weigtProperty();
}
