package io.github.chiangkaishek327.jge.event;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;

public record FXEventRecord<E extends Event>(EventType<E> event, EventHandler<E> eventHandler) {

}
