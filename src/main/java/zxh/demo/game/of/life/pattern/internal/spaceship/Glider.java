package zxh.demo.game.of.life.pattern.internal.spaceship;

import zxh.demo.game.of.life.pattern.GOLPattern;

/**
 * Glider:
 * @author zhangxuhai
 * @date 2019/11/8
*/
public class Glider extends GOLPattern {
    private static final boolean[][] SS_GLIDER = new boolean[][]{
            {false, false, false, false, false,},
            {false, false, true, false, false,},
            {false, false, false, true, false,},
            {false, true, true, true, false,},
            {false, false, false, false, false,},
    };

    @Override
    protected boolean[][] getStatusPattern() {
        return SS_GLIDER;
    }
}
