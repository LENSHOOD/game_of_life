package zxh.demo.game.of.life.pattern;

import org.junit.Assert;
import org.junit.Test;
import zxh.demo.game.of.life.block.Block;
import zxh.demo.game.of.life.helper.BlockHelper;
import zxh.demo.game.of.life.pattern.internal.still.StillBlock;

import java.util.Map;

/**
 * StillPatternTest:
 * @author zhangxuhai
 * @date 2019/11/7
*/
public class StillPatternTest {
    
    @Test
    public void should_return_block_when_given_start_point_0_0() {
        GOLPattern pattern = new StillBlock();
        Map<Block.Point, Block> patternMap =
                pattern.generate(0, 0, ((BlockHelper) size -> null).generateAllDead(4));
        Assert.assertTrue(patternMap.get(new Block.Point(1, 1)).isAlive());
        Assert.assertTrue(patternMap.get(new Block.Point(2, 1)).isAlive());
        Assert.assertTrue(patternMap.get(new Block.Point(1, 2)).isAlive());
        Assert.assertTrue(patternMap.get(new Block.Point(2, 2)).isAlive());
    }
}
