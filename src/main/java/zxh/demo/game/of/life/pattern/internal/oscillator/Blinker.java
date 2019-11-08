package zxh.demo.game.of.life.pattern.internal.oscillator;

import zxh.demo.game.of.life.pattern.GOLPattern;

/**
 * Blinker:
 * @author zhangxuhai
 * @date 2019/11/8
*/
public class Blinker extends GOLPattern {
    private static final boolean[][] OSC_BLINKER = new boolean[][]{
            {false, false, false, false, false},
            {false, false, false, false, false},
            {false, true, true, true, false},
            {false, false, false, false, false},
            {false, false, false, false, false},
    };

    @Override
    protected boolean[][] getStatusPattern() {
        return OSC_BLINKER;
    }
}
