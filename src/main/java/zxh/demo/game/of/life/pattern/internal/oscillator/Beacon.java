package zxh.demo.game.of.life.pattern.internal.oscillator;

import zxh.demo.game.of.life.pattern.GOLPattern;

/**
 * Beacon:
 * @author zhangxuhai
 * @date 2019/11/8
*/
public class Beacon extends GOLPattern {
    private static final boolean[][] OSC_TOAD = new boolean[][]{
            {false, false, false, false, false, false},
            {false, true, true, false, false, false},
            {false, true, true, false, false, false},
            {false, false, false, true, true, false},
            {false, false, false, true, true, false},
            {false, false, false, false, false, false},
    };

    @Override
    protected boolean[][] getStatusPattern() {
        return OSC_TOAD;
    }
}
