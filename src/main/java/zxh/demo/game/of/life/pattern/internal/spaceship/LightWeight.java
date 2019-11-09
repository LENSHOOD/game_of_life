package zxh.demo.game.of.life.pattern.internal.spaceship;

import zxh.demo.game.of.life.pattern.GOLPattern;

/**
 * LightWeight:
 * @author zhangxuhai
 * @date 2019/11/9
*/
public class LightWeight extends GOLPattern {
    private static final boolean[][] SS_LIGHT_WEIGHT = new boolean[][]{
            {false, true, true, true, true,},
            {true, false, false, false, true,},
            {false, false, false, false, true,},
            {true, false, false, true, false,},
    };

    @Override
    protected boolean[][] getStatusPattern() {
        return SS_LIGHT_WEIGHT;
    }
}
