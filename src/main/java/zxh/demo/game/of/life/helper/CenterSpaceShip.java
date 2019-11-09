package zxh.demo.game.of.life.helper;

import zxh.demo.game.of.life.block.Block;
import zxh.demo.game.of.life.pattern.GOLPattern;
import zxh.demo.game.of.life.pattern.internal.spaceship.Glider;
import zxh.demo.game.of.life.pattern.internal.spaceship.HeavyWeight;
import zxh.demo.game.of.life.pattern.internal.spaceship.LightWeight;
import zxh.demo.game.of.life.pattern.internal.spaceship.MiddleWeight;

import java.util.Map;
import java.util.Random;

/**
 * CenterSpaceShip:
 * @author zhangxuhai
 * @date 2019/11/8
*/
public class CenterSpaceShip implements BlockHelper {
    private static final GOLPattern[] PATTERNS = new GOLPattern[]{
            new Glider(), new LightWeight(), new MiddleWeight(), new HeavyWeight()
    };

    private Random random = new Random();

    @Override
    public Map<Block.Point, Block> generateBlocks(int size) {
        int offset = size / 2 - 1;
        return randomStill().generate(offset, offset, generateAllDead(size));
    }

    private GOLPattern randomStill() {
        return PATTERNS[random.nextInt(PATTERNS.length)];
    }
}
