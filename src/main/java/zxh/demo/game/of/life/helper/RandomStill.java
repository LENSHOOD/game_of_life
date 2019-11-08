package zxh.demo.game.of.life.helper;

import zxh.demo.game.of.life.block.Block;
import zxh.demo.game.of.life.pattern.GOLPattern;
import zxh.demo.game.of.life.pattern.internal.still.*;

import java.util.Map;
import java.util.Random;

/**
 * RamdomStill:
 * @author zhangxuhai
 * @date 2019/11/8
*/
public class RandomStill implements BlockHelper{
    private static final GOLPattern[] PATTERNS = new GOLPattern[]{
            new Beehive(), new StillBlock(), new Boat(), new Loaf(), new Tub()
    };

    private Random random = new Random();

    @Override
    public Map<Block.Point, Block> generateBlocks(int size) {
        int offset = size / 10;
        return randomStill().generate(offset, offset,
                randomStill().generate(size - offset, offset,
                        randomStill().generate(size - offset, size - offset,
                                randomStill().generate(offset, size - offset, generateAllDead(size)))));
    }

    private GOLPattern randomStill() {
        return PATTERNS[random.nextInt(5)];
    }
}
