package zxh.demo.game.of.life;

import zxh.demo.game.of.life.block.BlockMap;
import zxh.demo.game.of.life.helper.*;
import zxh.demo.game.of.life.printer.MatrixPrinter;

/**
 * Runner:
 * @author zhangxuhai
 * @date 2019/10/30
*/
public class Runner {
    private static final BlockHelper[] BLOCK_HELPERS = {
            new RandomLive(),
            new RandomStill(),
            new CenterOscillator(),
            new CenterSpaceShip(),
            new Fleet(),
    };

    public static void main(String[] args) throws InterruptedException {
        if (args.length != 3) {
            System.out.println("Usage: java -jar xxx.jar " +
                    "[size] [round] " +
                    "[0:random 1:still 2:oscillator 3:space ship 4:fleet]");
            return;
        }

        int size, round;
        try {
            size = Integer.parseInt(args[0]);
            round = Integer.parseInt(args[1]);
        } catch (Exception e) {
            System.out.println("Usage: java -jar xxx.jar [size] [round]");
            return;
        }

        BlockMap blockMap = BlockMap.init(size, BLOCK_HELPERS[Integer.parseInt(args[2])]);
        for (int i = 0; i < round; i++) {
            MatrixPrinter.printByMatrix(blockMap.getMatrix());
            blockMap.nextRound();
            Thread.sleep(200);
        }
    }
}
