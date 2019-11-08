package zxh.demo.game.of.life.pattern.internal.still;

import zxh.demo.game.of.life.pattern.GOLPattern;

/**
 * StillBeehive:
 * @author zhangxuhai
 * @date 2019/11/8
*/
public class StillBeehive extends GOLPattern {
    private static final boolean[][] STILL_BEEHIVE = new boolean[][]{
            {false, false, false, false, false, false},
            {false, false, true, true, false, false},
            {false, true, false, false, true, false},
            {false, false, true, true, false, false},
            {false, false, false, false, false, false},
    };

    @Override
    protected boolean[][] getStatusPattern() {
        return STILL_BEEHIVE;
    }
}
