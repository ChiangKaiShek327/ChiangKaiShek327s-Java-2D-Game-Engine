package io.github.chiangkaishek327.jge.object;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.Node;

public class GameObject {
    ObjectProperty<Node> spiritProperty = new SimpleObjectProperty<>();
    BoundBox boundBox;
}
