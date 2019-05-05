package com.rezilience.chutesnladders.service;

/**
 * Responsible to handle instances of the ChutesAndLaddersGame
 * Currently configured to provide only a single instance of game
 */
public class GameProvider {

    volatile private static ChutesAndLaddersGame instance;

    public static ChutesAndLaddersGame getInstance() {
        if (instance == null) {
            synchronized (ChutesAndLaddersGame.class) {
                if (instance == null) {
                    instance = new ChutesAndLaddersGame();
                }
            }
        }
        return instance;
    }
}
