package io.github.chiangkaishek327.jge.event;

public interface GameEvent<A> {
    public boolean match(long tick, A arg);

}
