package zxh.demo.game.of.life.helper;

import zxh.demo.game.of.life.Block;

import java.util.HashMap;
import java.util.Map;

/**
 * BlockHelper:
 * @author zhangxuhai
 * @date 2019/10/29
*/
public interface BlockHelper {
    Map<Block.Point, Block> generateBlocks(int size);

    default Map<Block.Point, Block> generateAllDead(int size) {
        Map<Block.Point, Block> blocks = new HashMap<>();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                Block block = new Block(i, j, false);
                blocks.put(block.getPoint(), block);
            }
        }

        return blocks;
    }
}
