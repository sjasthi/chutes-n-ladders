package com.rezilience.chutesnladders.service;

/**
 * Responsible to handle instances of the Game
 * Currently configured to provide only a single instance of game
 */
public class GameProvider {

    volatile private static Game instance;

    public static Game getInstance() {
        if (instance == null) {
            synchronized (Game.class) {
                if (instance == null) {
                    instance = new Game();
                }
            }
        }
        return instance;
    }
}
