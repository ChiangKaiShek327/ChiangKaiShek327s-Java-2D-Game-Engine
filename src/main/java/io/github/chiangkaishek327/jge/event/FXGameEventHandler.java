package io.github.chiangkaishek327.jge.event;

import javafx.event.Event;
import javafx.scene.Node;

public abstract class FXGameEventHandler<A, E extends GameEvent<A>, T extends Event> extends GameEventHandler<A, E> {
    public abstract void bind(Node node);

    public abstract void unbind();
}
