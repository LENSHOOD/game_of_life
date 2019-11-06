package zxh.demo.game.of.life.printer;

import org.knowm.xchart.XYChart;
import org.knowm.xchart.XYChartBuilder;

/**
 * MatrixPrinter:
 * @author zhangxuhai
 * @date 2019/11/6
*/
public class MatrixPrinter {
    private static XYChart chart = new XYChartBuilder()
                .height(1024).width(1024)
                .title("Matrix").xAxisTitle("").yAxisTitle("")
                .build();

    public static void printByMatrix(int[][] intMatrix) {
        int xLen = intMatrix.length;
        int yLen = intMatrix[0].length;
        int[] x = new int[xLen];
        int[] y = new int[yLen];
        for (int i = 0; i < xLen; i++) {
            for (int j = 0; j < yLen; j++) {
                if (intMatrix[i][j] != 0) {

                }
            }
        }
    }
}
