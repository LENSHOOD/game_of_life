package zxh.demo.game.of.life.pattern;

import zxh.demo.game.of.life.block.Block;

import java.util.Arrays;
import java.util.Map;

/**
 * GOLPattern:
 * @author zhangxuhai
 * @date 2019/11/8
*/
public abstract class GOLPattern {

    /**
     * Generate dead/alive pattern in map
     * @param x x offset
     * @param y y offset
     * @param blockMap the block map that will generate pattern to it
     * @return dead/alive map
     */
    public Map<Block.Point, Block> generate(int x, int y, int timesOfRotateToNinetyDegrees, Map<Block.Point, Block> blockMap) {

        boolean[][] statusPattern = getStatusPattern();
        for (int i = 0; i < timesOfRotateToNinetyDegrees % 4; i++) {
            statusPattern = clockWiseRotateNinetyDegrees(statusPattern);
        }
        for (int i = 0; i < statusPattern.length; i++) {
            for (int j = 0; j < statusPattern[0].length; j++) {
                blockMap.get(new Block.Point(i + x, j + y))
                        .setAlive(statusPattern[i][j]);
            }
        }
        return blockMap;
    }

    protected abstract boolean[][] getStatusPattern();

    public boolean[][] clockWiseRotateNinetyDegrees(boolean[][] originalMatrix) {
        int len = originalMatrix.length;
        boolean[][] resultMatrix = new boolean[len][];
        for (int i = 0; i < len; i++) {
            resultMatrix[i] = Arrays.copyOf(originalMatrix[i], originalMatrix[i].length);
        }

        for (int i = 0; i < len / 2; i++)
        {
            for (int j = i; j < len - i - 1; j++)
            {

                // Swap elements of each cycle
                // in clockwise direction
                boolean temp = resultMatrix[i][j];
                resultMatrix[i][j] = resultMatrix[len - 1 - j][i];
                resultMatrix[len - 1 - j][i] = resultMatrix[len - 1 - i][len - 1 - j];
                resultMatrix[len - 1 - i][len - 1 - j] = resultMatrix[j][len - 1 - i];
                resultMatrix[j][len - 1 - i] = temp;
            }
        }

        return resultMatrix;
    }
}
