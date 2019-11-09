package zxh.demo.game.of.life.pattern.internal.spaceship;

import zxh.demo.game.of.life.pattern.GOLPattern;

/**
 * HeavyWeight:
 * @author zhangxuhai
 * @date 2019/11/9
*/
public class HeavyWeight extends GOLPattern {
    private static final boolean[][] SS_HEAVY_WEIGHT = new boolean[][]{
            {false, true, true, true, true, true, true},
            {true, false, false, false, false, false, true,},
            {false, false, false, false, false, false, true,},
            {true, false, false, false, false, true, false,},
            {false, false, true, true, false, false, false,},
    };

    @Override
    protected boolean[][] getStatusPattern() {
        return SS_HEAVY_WEIGHT;
    }

}
