package zxh.demo.game.of.life.helper;

import zxh.demo.game.of.life.block.Block;
import zxh.demo.game.of.life.helper.exception.BlockHelperException;
import zxh.demo.game.of.life.pattern.GOLPattern;
import zxh.demo.game.of.life.pattern.internal.spaceship.Glider;
import zxh.demo.game.of.life.pattern.internal.spaceship.HeavyWeight;
import zxh.demo.game.of.life.pattern.internal.spaceship.LightWeight;
import zxh.demo.game.of.life.pattern.internal.spaceship.MiddleWeight;

import java.util.EnumMap;
import java.util.Map;

/**
 * Fleet:
 * @author zhangxuhai
 * @date 2019/11/9
*/
public class Fleet implements BlockHelper {
    private enum SpaceShips {
        Glider, LightWeight, MiddleWeight, HeavyWeight
    }

    private static final Map<SpaceShips, GOLPattern> dock = new EnumMap<>(SpaceShips.class);
    static {
        dock.put(SpaceShips.Glider, new Glider());
        dock.put(SpaceShips.LightWeight, new LightWeight());
        dock.put(SpaceShips.MiddleWeight, new MiddleWeight());
        dock.put(SpaceShips.HeavyWeight, new HeavyWeight());
    }

    @Override
    public Map<Block.Point, Block> generateBlocks(int size) {
        if (size < 100) {
            throw new BlockHelperException("Size too small");
        }

        Map<Block.Point, Block> battleFlied = generateAllDead(size);
        // bottom line
        deploy(SpaceShips.MiddleWeight, 20, 0, 0, battleFlied);
        deploy(SpaceShips.MiddleWeight, 30, 0, 0, battleFlied);
        deploy(SpaceShips.HeavyWeight, 40, 0, 0, battleFlied);
        deploy(SpaceShips.HeavyWeight, 50, 0, 0, battleFlied);
        deploy(SpaceShips.HeavyWeight, 60, 0, 0, battleFlied);
        deploy(SpaceShips.MiddleWeight, 70, 0, 0, battleFlied);
        deploy(SpaceShips.MiddleWeight, 80, 0, 0, battleFlied);

        // second line
        deploy(SpaceShips.MiddleWeight, 30, 10, 0, battleFlied);
        deploy(SpaceShips.MiddleWeight, 40, 10, 0, battleFlied);
        deploy(SpaceShips.MiddleWeight, 50, 10, 0, battleFlied);
        deploy(SpaceShips.MiddleWeight, 60, 10, 0, battleFlied);
        deploy(SpaceShips.MiddleWeight, 70, 10, 0, battleFlied);

        // first line
        deploy(SpaceShips.LightWeight, 40, 20, 0, battleFlied);
        deploy(SpaceShips.LightWeight, 50, 20, 0, battleFlied);
        deploy(SpaceShips.LightWeight, 60, 20, 0, battleFlied);

        // corner
        deploy(SpaceShips.Glider, 55, 30, 0, battleFlied);
        deploy(SpaceShips.Glider, 45, 30, 3, battleFlied);

        return battleFlied;
    }

    private void deploy(SpaceShips type, int locationX, int locationY, int timesOfRotateNinetyDegrees, Map<Block.Point, Block> battleFlied) {
        dock.get(type).generate(locationX, locationY, timesOfRotateNinetyDegrees, battleFlied);
    }
}
