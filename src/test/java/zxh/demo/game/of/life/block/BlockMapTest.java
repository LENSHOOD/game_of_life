package zxh.demo.game.of.life.block;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import zxh.demo.game.of.life.exception.BlockMapException;
import zxh.demo.game.of.life.helper.BlockHelper;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BlockMapTest {

    private BlockHelper blockHelper = mock(BlockHelper.class);

    @Before
    public void init() {
        Map<Block.Point, Block> mockBlocks = new HashMap<>();
        when(blockHelper.generateBlocks(anyInt())).thenReturn(mockBlocks);
    }

    @Test
    public void should_return_length_is_25_when_n_is_5() {
        Map<Block.Point, Block> mockBlocks = blockHelper.generateBlocks(5);
        IntStream.range(1, 26).forEach(i -> mockBlocks.put(new Block.Point(i, i*10), new Block(i, i*10, false)));

        assertEquals(25, BlockMap.init(5, blockHelper).size());
    }

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void should_n_greater_than_0() {
        expectedException.expect(BlockMapException.class);
        BlockMap.init(0, blockHelper);
    }

    @Test
    public void should_n_less_than_1001() {
        expectedException.expect(BlockMapException.class);
        BlockMap.init(1001, blockHelper);
    }
    
    @Test
    public void should_sum_0_when_all_dead() {
        BlockMap blockMap = BlockMap.init(5, new BlockHelper() {
            @Override
            public Map<Block.Point, Block> generateBlocks(int size) {
                return generateAllDead(size);
            }
        });

        assertEquals(0, blockMap.gatherNeighbors(3, 3));
    }

    @Test
    public void should_sum_2_when_2_alive() {
        BlockMap blockMap = BlockMap.init(5, new BlockHelper() {
            @Override
            public Map<Block.Point, Block> generateBlocks(int size) {
                Map<Block.Point, Block> blocks = generateAllDead(size);
                blocks.get(new Block.Point(3, 2)).setAlive(true);
                blocks.get(new Block.Point(4, 4)).setAlive(true);
                return blocks;
            }
        });

        assertEquals(2, blockMap.gatherNeighbors(3, 3));
    }

}