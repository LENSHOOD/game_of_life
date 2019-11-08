package zxh.demo.game.of.life.helper;

import zxh.demo.game.of.life.block.Block;
import zxh.demo.game.of.life.pattern.GOLPattern;
import zxh.demo.game.of.life.pattern.internal.oscillator.Beacon;
import zxh.demo.game.of.life.pattern.internal.oscillator.Blinker;
import zxh.demo.game.of.life.pattern.internal.oscillator.Toad;

import java.util.Map;
import java.util.Random;

/**
 * CenterOscillator:
 * @author zhangxuhai
 * @date 2019/11/8
*/
public class CenterOscillator implements BlockHelper {
    private static final GOLPattern[] PATTERNS = new GOLPattern[]{
            new Blinker(), new Beacon(), new Toad()
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
