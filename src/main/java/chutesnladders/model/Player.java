package chutesnladders.model;

import lombok.Getter;

@Getter
public class Player {
    private boolean bot;
    private String name;
    private Integer position;
    private boolean onFinishPoint;
    private int playerId;
    private Integer rank;

    public void setRank(int rank) {
        this.rank = rank;
    }

    public Player(String name) {
        this(name, false);
    }

    public Player(String name, boolean bot) {
        this.name = name;
        this.bot = bot;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public void setOnFinishPoint(boolean onFinishPoint) {
        this.onFinishPoint = onFinishPoint;
    }

    @Override
    public String toString() {
        return name;
    }
}
