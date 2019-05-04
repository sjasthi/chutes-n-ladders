package com.rezilience.runner;

import com.rezilience.chutesnladders.Game;
import com.rezilience.chutesnladders.model.Jump;
import com.rezilience.chutesnladders.model.MoveResult;
import com.rezilience.chutesnladders.model.Player;

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
            if (moveResult.isMoveSuccess()) {
                System.out.print(moves++ + ": " + player + ": "
                        + moveResult.getFromCell()
                        + " --> " + (moveResult.getFromCell() + moveResult.getSpinValue()));
                for (Jump jump : moveResult.getJumps()) {
                    System.out.print(" --" + jump.getJumpType() + "--> " + jump.getToBlock());

                }
            } else {
                System.out.print(moves++ + ": " + player + ": "
                        + moveResult.getFromCell()
                        + " -x-> " + (moveResult.getFromCell() + moveResult.getSpinValue())
                        + " --> " + moveResult.getFromCell());
            }
            System.out.println();

            isWinner = player.isOnFinishPoint();
        } while (!isWinner);

        System.out.println("The winner is " + player + "!");
    }
}
