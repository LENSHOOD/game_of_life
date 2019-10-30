package zxh.demo.game.of.life.helper;

import org.junit.Test;
import zxh.demo.game.of.life.block.Block;

import java.util.Map;

import static org.junit.Assert.assertTrue;

public class RandomLiveTest {
    @Test
    public void should_get_some_live_blocks() {
        BlockHelper blockHelper = new RandomLive();
        Map<Block.Point, Block> blocks = blockHelper.generateBlocks(5);
        assertTrue(blocks.entrySet().stream().anyMatch(e -> e.getValue().isAlive()));
    }
}