/** Demonstrating the code changes and pull requests **/

package com.rezilience.chutesnladders;

import com.rezilience.chutesnladders.exception.GameSetupException;
import com.rezilience.chutesnladders.model.Player;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class GameTest {

    private static Game game;

    @BeforeClass
    public static void init() {
        game = Game.getInstance();
    }

    @Test(expected = GameSetupException.class)
    public void testDuplicateSetupFailure() {
        List<Player> list = Arrays.asList(new Player("Derek"), new Player("Natasha"));
        game.setupNewGame(list);
        game.setupNewGame(list);
    }

    @Test(expected = GameSetupException.class)
    public void testNextMoveWithoutSetup() {
        game.clearCurrentGame();
        game.nextMove();
    }

    @Test(expected = GameSetupException.class)
    public void testGetPlayersWithoutSetup() {
        game.clearCurrentGame();
        game.getPlayerList();
    }

    @Test
    public void testIsActive() {
        List<Player> list = Arrays.asList(new Player("Derek"), new Player("Natasha"));
        game.setupNewGame(list);
        assertTrue(game.isSetup());

        game.clearCurrentGame();
        assertFalse(game.isSetup());
    }
}
