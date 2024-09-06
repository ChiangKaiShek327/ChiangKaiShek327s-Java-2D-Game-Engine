package io.github.chiangkaishek327.jge.event.key;

import io.github.chiangkaishek327.jge.event.FXEventRecord;
import io.github.chiangkaishek327.jge.event.FXGameEventHandler;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.Node;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.util.ArrayList;
import java.util.List;

public class KeyGameEventHandler extends FXGameEventHandler<KeyGameEventArgs, KeyGameEvent, KeyEvent> {
    protected final ObservableList<KeyCode> pressedKeys = FXCollections.observableArrayList();
    protected final ObservableList<KeyCode> releasedKeys = FXCollections.observableArrayList();
    protected final FXEventRecord<KeyEvent> eventPress = new FXEventRecord<>(KeyEvent.KEY_PRESSED, e -> {
        pressedKeys.add(e.getCode());
        releasedKeys.add(e.getCode());
    });
    protected final FXEventRecord<KeyEvent> eventRelease = new FXEventRecord<>(KeyEvent.KEY_PRESSED, e -> {
        pressedKeys.remove(e.getCode());
        releasedKeys.add(e.getCode());
    });
    protected final ObjectProperty<Node> target = new SimpleObjectProperty<>();

    @SuppressWarnings("unchecked")
    @Override
    public void bind(Node node) {
        target.set(node);
        for (FXEventRecord<KeyEvent> ecs : new FXEventRecord[] { eventPress, eventRelease }) {
            ecs.addHandlerToNode(target.get());
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public void unbind() {
        for (FXEventRecord<KeyEvent> ecs : new FXEventRecord[] { eventPress, eventRelease }) {
            ecs.removeHandlerToNode(target.get());
        }
    }

    @Override
    public void handle(long tick) {
        for (KeyGameEvent keyGameEvent : events) {
            keyGameEvent.match(tick, new KeyGameEventArgs(KeyEvent.KEY_PRESSED, pressedKeys));

            keyGameEvent.match(tick, new KeyGameEventArgs(KeyEvent.KEY_RELEASED, releasedKeys));

        }
        releasedKeys.clear();
    }

    public ObjectProperty<Node> targetProperty() {
        return target;
    }

    public Node getTarget() {
        return target.get();
    }

    public void setTarget(Node code) {
        target.set(code);
    }

    public ObservableList<KeyCode> getPressedKeys() {
        return pressedKeys;
    }

    public ObservableList<KeyCode> getReleasedKeys() {
        return releasedKeys;
    }
}
