package io.github.chiangkaishek327.jge.event.key;

import java.util.Collection;

import javafx.event.EventType;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public record KeyGameEventArgs(EventType<KeyEvent> event, Collection<KeyCode> keyCodes) {

}
