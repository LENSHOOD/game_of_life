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
        BlockMap blockMap = BlockMap.init(30, new RandomLive());
        for (int i = 0; i < 100; i++) {
            System.out.println(blockMap.toString());
            blockMap.nextRound();
            Thread.sleep(200);
            Runtime.getRuntime().exec("clear");
        }
    }
}
