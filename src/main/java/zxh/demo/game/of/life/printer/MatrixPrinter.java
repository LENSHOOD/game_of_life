package zxh.demo.game.of.life.printer;

import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;
import org.knowm.xchart.XYChartBuilder;
import org.knowm.xchart.XYSeries;
import org.knowm.xchart.style.markers.SeriesMarkers;

import java.util.ArrayList;
import java.util.List;

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
    private static SwingWrapper sw = new SwingWrapper(chart);
    static {
        chart.getStyler().setDefaultSeriesRenderStyle(XYSeries.XYSeriesRenderStyle.Scatter);
        chart.addSeries("Alive", new int[]{0}, new int[]{0});
        sw.displayChart();

        // wait canvas to initialize
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public static void printByMatrix(int[][] intMatrix) {
        int xLen = intMatrix.length;
        int yLen = intMatrix[0].length;
        List<int[]> resultList = new ArrayList<>();
        for (int i = 0; i < xLen; i++) {
            for (int j = 0; j < yLen; j++) {
                if (intMatrix[i][j] != 0) {
                    resultList.add(new int[]{i, j});
                }
            }
        }

        // expand canvas
        resultList.add(new int[]{0, 0});
        resultList.add(new int[]{xLen, yLen});

        double[] x = new double[resultList.size()];
        double[] y = new double[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            x[i] = resultList.get(i)[0];
            y[i] = resultList.get(i)[1];
        }

        chart.updateXYSeries("Alive", x, y, null).setMarker(SeriesMarkers.CIRCLE);
        sw.repaintChart();
    }
}
