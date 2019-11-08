package zxh.demo.game.of.life.pattern.internal.still;

import zxh.demo.game.of.life.pattern.GOLPattern;

/**
 * StillTub:
 * @author zhangxuhai
 * @date 2019/11/8
*/
public class StillTub extends GOLPattern {
    private static final boolean[][] STILL_TUB = new boolean[][]{
            {false, false, false, false, false,},
            {false, false, true, false, false,},
            {false, true, false, true, false,},
            {false, false, true, false, false,},
            {false, false, false, false, false,},
    };

    @Override
    protected boolean[][] getStatusPattern() {
        return STILL_TUB;
    }

}
