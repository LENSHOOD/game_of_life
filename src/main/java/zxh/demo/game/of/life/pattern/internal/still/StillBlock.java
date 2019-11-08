package zxh.demo.game.of.life.pattern.internal.still;

import zxh.demo.game.of.life.pattern.GOLPattern;

/**
 * StillBlock:
 * @author zhangxuhai
 * @date 2019/11/8
*/
public class StillBlock extends GOLPattern {
    private static final boolean[][] STILL_BLOCK = new boolean[][]{
            {false, false, false, false},
            {false, true, true, false},
            {false, true, true, false},
            {false, false, false, false},
    };

    @Override
    protected boolean[][] getStatusPattern() {
        return STILL_BLOCK;
    }
}
