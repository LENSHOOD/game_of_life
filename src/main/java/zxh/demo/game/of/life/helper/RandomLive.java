package zxh.demo.game.of.life.helper;

import zxh.demo.game.of.life.block.Block;

import java.util.*;

/**
 * RandomLive:
 * @author zhangxuhai
 * @date 2019/10/30
*/
public class RandomLive implements BlockHelper {

    private Random random = new Random();

    @Override
    public Map<Block.Point, Block> generateBlocks(int size) {
        Map<Block.Point, Block> blocks = generateAllDead(size);
        blocks.putAll(getRandomAliveBlocks(size));
        return blocks;
    }

    private Map<Block.Point, Block> getRandomAliveBlocks(int size) {
        Map<Block.Point, Block> randomAliveMap = new HashMap<>();
        int randomCount = random.nextInt(size * size / 8);
        for (int i = 0; i < randomCount; i++) {
            Block block = new Block(
                    random.nextInt(size - 1),
                    random.nextInt(size - 1),
                    true);
            randomAliveMap.put(block.getPoint(), block);
        }
        return randomAliveMap;
    }

}
