package chutesnladders.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class GameBoard {

    private final int startBlock = 0;
    private final int finishBlock = 100;
    private List<Block> blockList;

    public GameBoard() {
        blockList = getBlockList(startBlock, finishBlock);
    }

    public int getStartBlock() {
        return startBlock;
    }

    public int getFinishBlock() {
        return finishBlock;
    }

    private List<Block> getBlockList(int startBlock, int finishBlock) {
        Map<Integer, Jump> JUMP_MAP = JumpUtils.getStartBlockJumpMap();
        blockList = new ArrayList<>();

        for (int i = startBlock; i <= finishBlock; i++) {
            Optional<Jump> jumpOptional = Optional.ofNullable(JUMP_MAP.get(i));

            if (jumpOptional.isPresent()
                    && jumpOptional.get().getToBlock() <= this.finishBlock)
                blockList.add(new Block(i, jumpOptional.get()));
            else blockList.add(new Block(i));
        }
        return blockList;
    }

    public Block getBlockAt(int position) {
        return blockList.get(position);
    }
}
