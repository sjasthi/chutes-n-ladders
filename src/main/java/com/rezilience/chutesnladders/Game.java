package com.rezilience.chutesnladders;

import com.rezilience.chutesnladders.exception.GameInitializationException;
import com.rezilience.chutesnladders.model.*;

import java.util.*;

public class Game {
    private static final int MIN_PLAYERS = 2;
    private static final int MAX_PLAYERS = 4;

    private final Deque<Player> playerDeque;
    private final List<Player> playerList;
    private final Spinner spinner;
    private int rank = 1;
    private GameBoard board;

    public Game(List<Player> playerList) {

        if (playerList.size() < MIN_PLAYERS) {
            throw new GameInitializationException("At least " + MIN_PLAYERS + " needed to start the game.");
        } else if (playerList.size() > MAX_PLAYERS) {
            throw new GameInitializationException("At most " + MAX_PLAYERS + " allowed.");
        }

        // get the chutes and ladders game board
        board = new GameBoard();

        // randomly order the players and assign a unique id to each
        initializePlayers(playerList);

        this.playerList = Collections.unmodifiableList(playerList);
        this.playerDeque = new ArrayDeque<>(playerList);

        // get a spinner
        spinner = new Spinner();
    }

    /**
     * Randomly order the players and assign needed properties like a unique id, may be color, etc
     *
     * @param playerList
     */
    private void initializePlayers(List<Player> playerList) {
        // get randomly ordered playerDeque
        Collections.shuffle(playerList);
        int id = 1;
        for (Player player : playerList) {
            player.setPlayerId(id++);
            player.setPosition(board.getStartBlock());
        }
    }

    /**
     * To return the list of players
     * can be used to initially show the order of players or the ranks of each player at the end
     *
     * @return playerList list of players
     */
    public List<Player> getPlayerList() {
        return new ArrayList<>(playerList);
    }

    /**
     * get newPosition = currentPosition + spinner.spin()
     * IF newPosition > lastBlock return empty moveResult for currentPlayer
     * ELSE IF newPosition = lastBlock prompt to end or continue game
     * ELSE
     * IF !blocks[newPosition].hasJump return moveResult with moveDetails
     * ELSE
     * WHILE blocks[newPosition].hasJump
     * execute the jump
     * END WHILE
     * END IF
     *
     * @return MoveResult: details of the move including jumps if any
     */
    public MoveResult nextMove() {

        // TODO check that the game has not already ended since this is a public method, worth having that check

        Player currentPlayer = getAndUpdateCurrentPlayer();

        MoveResult moveResult = new MoveResult(currentPlayer);
        moveResult.setFromCell(currentPlayer.getPosition());
        int spin = spinner.spin();
        moveResult.setSpinValue(spin);

        int newPosition = currentPlayer.getPosition() + spin;

        if (newPosition > board.getFinishBlock()) {
            // the move crosses the last block and hence can't be executed
            return moveResult;
        } else {
            moveResult.setMoveSuccess(true);

            Block block = board.getBlockAt(newPosition);
            Optional<Jump> jumpOptional = block.getJumpOptional();

            while (jumpOptional.isPresent()) {
                Jump jump = jumpOptional.get();
                newPosition = jump.getToBlock();
                moveResult.getJumps().add(jump);
                jumpOptional = board.getBlockAt(newPosition).getJumpOptional();
            }

            currentPlayer.setPosition(newPosition);

            if (newPosition == board.getFinishBlock()) {
                currentPlayer.setOnFinishPoint(true);
                // TODO ideally this is where you want to update the rank
            }

            // TODO ideally this is where you want to update the deque
        }

        return moveResult;
    }

    private Player getAndUpdateCurrentPlayer() {

        int finishBlock = board.getFinishBlock();

        Player player;
        do {
            player = playerDeque.pollFirst();
        } while (!playerDeque.isEmpty() && player.getPosition() == finishBlock);

        if (player.getPosition() != finishBlock)
            playerDeque.offerLast(player);
        else player.setRank(getAndUpdateRank());

        if (playerDeque.isEmpty()) {
            // TODO handle game over scenario
        }

        return player;
    }

    private int getAndUpdateRank() {
        return rank++;
    }
}
