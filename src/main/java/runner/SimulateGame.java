package runner;

import chutesnladders.Game;
import chutesnladders.model.Jump;
import chutesnladders.model.MoveResult;
import chutesnladders.model.Player;

import java.util.Arrays;

public class SimulateGame {
    public static void main(String[] args) {
        startSimulation();
    }

    private static void startSimulation() {
        Player eric = new Player("Eric", true);
        Player paul = new Player("Paul", true);
        Game game = new Game(Arrays.asList(eric, paul));

        int moves = 1;
        boolean isWinner;
        Player player;
        do {
            MoveResult moveResult = game.nextMove();
            player = moveResult.getPlayer();
            System.out.print(moves++ + ": " + player + ": "
                    + moveResult.getFromCell()
                    + " --> " + (moveResult.getFromCell() + moveResult.getSpinValue()));
            for (Jump jump : moveResult.getJumps()) {
                System.out.print(" --" + jump.getJumpType() + "--> " + jump.getToBlock());
            }
            System.out.println();

            isWinner = player.isOnFinishPoint();
        } while (!isWinner);

        System.out.println("The winner is " + player + "!");
    }
}
