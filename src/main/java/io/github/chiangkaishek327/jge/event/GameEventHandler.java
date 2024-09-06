package io.github.chiangkaishek327.jge.event;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public abstract class GameEventHandler<A, E extends GameEvent<A>> {
    protected final ObservableList<E> events = FXCollections.observableArrayList();

    public abstract void handle(long tick);

    public ObservableList<E> getEvents() {
        return events;
    }

}
