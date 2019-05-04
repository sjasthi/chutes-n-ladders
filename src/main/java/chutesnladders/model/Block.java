package chutesnladders.model;

import java.util.Optional;

public class Block {
    private final int position;
    private final Jump jump;

    Block(int position) {
        this(position, null);
    }

    Block(int position, Jump jump) {
        this.position = position;
        this.jump = jump;
    }

    public int getPosition() {
        return position;
    }

    public Optional<Jump> getJumpOptional() {
        return Optional.ofNullable(jump);
    }
}
