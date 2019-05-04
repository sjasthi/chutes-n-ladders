package com.rezilience.chutesnladders.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class MoveResult {
    private Player player;
    private int fromCell;
    private int spinValue;
    private List<Jump> jumps;
    private boolean moveSuccess;

    public MoveResult(Player player) {
        this.player = player;
        this.jumps = new ArrayList<>();
    }
}
