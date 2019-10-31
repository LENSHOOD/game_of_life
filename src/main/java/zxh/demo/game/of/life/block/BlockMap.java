package zxh.demo.game.of.life.block;

import zxh.demo.game.of.life.exception.BlockMapException;
import zxh.demo.game.of.life.helper.BlockHelper;

import java.util.Map;
import java.util.Objects;

/**
 * BlockMap:
 * @author zhangxuhai
 * @date 2019/10/29
*/
public class BlockMap {
    private static final int MIN = 1;
    private static final int MAX = 1000;
    private Map<Block.Point, Block> blocks;

    private BlockMap() {
        // empty
    }

    public static BlockMap init(int n, BlockHelper blockHelper) {
        if (validate(n)) {
            throw new BlockMapException("The range of n should be 1~1000");
        }

        BlockMap blockMap = new BlockMap();
        blockMap.blocks = blockHelper.generateBlocks(n);
        return blockMap;
    }

    private static boolean validate(int n) {
        return n < MIN || n > MAX;
    }

    public int size() {
        return blocks.size();
    }

    public int gatherNeighbors(int x, int y) {
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

    public void nextRound() {
        blocks.forEach((point, block) -> block.trySurvive(gatherNeighbors(point.getX(), point.getY())));
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        int n = (int) Math.sqrt(size());
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result.append(blocks.get(new Block.Point(i, j))).append(" ");
            }
            result.append("\n");
        }
        return result.toString();
    }
}
