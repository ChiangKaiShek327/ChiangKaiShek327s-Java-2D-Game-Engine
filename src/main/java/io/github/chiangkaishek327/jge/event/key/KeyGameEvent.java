package io.github.chiangkaishek327.jge.event.key;

import io.github.chiangkaishek327.jge.event.GameEvent;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.LongProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.event.EventType;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public abstract class KeyGameEvent implements GameEvent<KeyGameEventArgs> {
    protected final BooleanProperty hasBeenPressed = new SimpleBooleanProperty(false);
    protected final ObjectProperty<KeyCode> keyCode = new SimpleObjectProperty<>(KeyCode.SPACE);
    protected final LongProperty pressedTicks = new SimpleLongProperty(0);

    @Override
    public boolean match(long tick, KeyGameEventArgs arg) {

        if (arg.keyCodes().contains(keyCode.get())) {
            EventType<KeyEvent> eventType = arg.event();
            if (eventType == KeyEvent.KEY_RELEASED) {
                onRelease(tick, pressedTicks.get());
                pressedTicks.set(0);
                hasBeenPressed.set(false);
            } else {
                hasBeenPressed.set(true);
                if (pressedTicks.get() <= 0) {
                    onKeyDown(tick);
                } else {
                    onPressing(tick, pressedTicks.get());
                }
                pressedTicks.set(pressedTicks.get() + 1);
            }
            return true;
        } else {
            return false;
        }
    }

    protected boolean isHasBeenPressed() {
        return hasBeenPressed.get();
    }

    public ObjectProperty<KeyCode> keyCodeProperty() {
        return keyCode;
    }

    public KeyCode getKeyCode() {
        return keyCode.get();
    }

    public void setKeyCode(KeyCode code) {
        keyCode.set(code);
    }

    public long getPressedTicks() {
        return pressedTicks.get();
    }

    public abstract void onKeyDown(long tick);

    public abstract void onPressing(long tick, long pressedTick);

    public abstract void onRelease(long tick, long pressedTick);
}
