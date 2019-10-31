package zxh.demo.game.of.life;

import zxh.demo.game.of.life.block.BlockMap;
import zxh.demo.game.of.life.helper.RandomLive;

import java.io.IOException;

/**
 * Runner:
 * @author zhangxuhai
 * @date 2019/10/30
*/
public class Runner {
    public static void main(String[] args) throws InterruptedException, IOException {
        if (args.length != 2) {
            System.out.println("Usage: java -jar xxx.jar [size] [round]");
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

        BlockMap blockMap = BlockMap.init(size, new RandomLive());
        for (int i = 0; i < round; i++) {
            System.out.println(blockMap.toString());
            blockMap.nextRound();
            Thread.sleep(200);
            Runtime.getRuntime().exec("clear");
        }
    }
}
