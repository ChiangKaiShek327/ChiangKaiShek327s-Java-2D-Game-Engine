package io.github.chiangkaishek327.jge.event;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleLongProperty;

public class Timer {
    protected final LongProperty currentTick = new SimpleLongProperty(0);
    protected final LongProperty millPerTick = new SimpleLongProperty(0);
    protected final DoubleProperty tps = new SimpleDoubleProperty(0);
    protected final BooleanProperty running = new SimpleBooleanProperty(false);

    public LongProperty currentTickProperty() {
        return currentTick;
    }

    public LongProperty millPerTickProperty() {
        return millPerTick;
    }

    public DoubleProperty tpsProperty() {
        return tps;
    }

    public BooleanProperty runningProperty() {
        return running;
    }

}
