package zxh.demo.game.of.life.pattern;

import zxh.demo.game.of.life.block.Block;

import java.util.Map;

/**
 * GOLPattern:
 * @author zhangxuhai
 * @date 2019/11/8
*/
public abstract class GOLPattern {

    /**
     * Generate dead/alive pattern in map
     * @param x x offset
     * @param y y offset
     * @param blockMap the block map that will generate pattern to it
     * @return dead/alive map
     */
    public Map<Block.Point, Block> generate(int x, int y, Map<Block.Point, Block> blockMap) {
        boolean[][] stillBlock = getStatusPattern();
        for (int i = 0; i < stillBlock.length; i++) {
            for (int j = 0; j < stillBlock[0].length; j++) {
                blockMap.get(new Block.Point(i + x, j + y))
                        .setAlive(stillBlock[i][j]);
            }
        }
        return blockMap;
    }

    protected abstract boolean[][] getStatusPattern();
}
