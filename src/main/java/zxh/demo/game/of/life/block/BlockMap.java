package zxh.demo.game.of.life.block;

import zxh.demo.game.of.life.block.exception.BlockMapException;
import zxh.demo.game.of.life.helper.BlockHelper;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/**
 * BlockMap:
 * @author zhangxuhai
 * @date 2019/10/29
*/
public class BlockMap {
    private static final int MIN = 1;
    private static final int MAX = 1000;
    private Map<Block.Point, Block> blocks;
    private static int length;

    private BlockMap() {
        // empty
    }

    public static BlockMap init(int n, BlockHelper blockHelper) {
        if (validate(n)) {
            throw new BlockMapException("The range of n should be 1~1000");
        }

        length = n;
        BlockMap blockMap = new BlockMap();
        blockMap.blocks = blockHelper.generateBlocks(n);
        return blockMap;
    }

    private static boolean validate(int n) {
        return n < MIN || n > MAX;
    }

    public void nextRound() {
        Map<Block.Point, Block> nextBlockMap = new HashMap<>();
        blocks.forEach((point, block) -> {
            Block nextBlock = Block.of(block);
            nextBlock.trySurvive(gatherNeighbors(point.getX(), point.getY()));
            nextBlockMap.put(point, nextBlock);
        });
        blocks = nextBlockMap;
    }

    int gatherNeighbors(int x, int y) {
        Block self = blocks.get(new Block.Point(x, y));
        if (Objects.isNull(self)) {
            return 0;
        }

        int sum = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                Block.Point currentPoint = new Block.Point(x + i, y + j);
                boolean isItself = i == 0 && j == 0;
                if (isItself || !blocks.containsKey(currentPoint)) {
                    continue;
                }

                if (blocks.get(currentPoint).isAlive()) {
                    sum += 1;
                }
            }
        }

        return sum;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                result.append(blocks.get(new Block.Point(i, j))).append(" ");
            }
            result.append("\n");
        }
        return result.toString();
    }

    public int[][] getMatrix() {
        int[][] result = new int[length][length];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                Block block = blocks.get(new Block.Point(i, j));
                result[i][j] = block.isAlive() ? 1 : 0;
            }
        }
        return result;
    }

    public int size() {
        return blocks.size();
    }

    public Optional<Block> getBlock(int x, int y) {
        return Optional.of(blocks.get(new Block.Point(x, y)));
    }
}
