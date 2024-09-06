package io.github.chiangkaishek327.jge.event;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.Node;

public record FXEventRecord<E extends Event>(EventType<E> event, EventHandler<E> eventHandler) {
    public void addHandlerToNode(Node node) {
        node.addEventHandler(event, eventHandler);
    }

    public void removeHandlerToNode(Node node) {
        node.removeEventHandler(event, eventHandler);
    }
}
