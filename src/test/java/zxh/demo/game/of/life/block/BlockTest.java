package zxh.demo.game.of.life.block;

import org.junit.Test;
import zxh.demo.game.of.life.block.Block;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BlockTest {
    @Test
    public void should_dead_to_alive_when_neighbor_sum_is_3() {
        Block block = new Block(0, 0, false);
        block.trySurvive(3);
        assertTrue(block.isAlive());
    }
    
    @Test
    public void should_still_alive_when_neighbor_sum_is_2_or_3() {
        Block block = new Block(0, 0, true);
        block.trySurvive(2);
        assertTrue(block.isAlive());
        block.trySurvive(3);
        assertTrue(block.isAlive());
    }
    
    @Test
    public void should_alive_to_dead_when_neighbor_sum_less_than_2() {
        Block block = new Block(0, 0, true);
        block.trySurvive(1);
        assertFalse(block.isAlive());
    }
    
    @Test
    public void should_alive_to_dead_when_neighbor_sum_greater_than_3() {
        Block block = new Block(0, 0, true);
        block.trySurvive(4);
        assertFalse(block.isAlive());
    }
}