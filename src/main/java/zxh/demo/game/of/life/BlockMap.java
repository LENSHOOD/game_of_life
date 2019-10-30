package zxh.demo.game.of.life;

import zxh.demo.game.of.life.helper.BlockHelper;

import java.util.Map;

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
}
