package zxh.demo.game.of.life.printer;

import org.junit.Test;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;
import org.knowm.xchart.XYChartBuilder;
import org.knowm.xchart.XYSeries;
import org.knowm.xchart.style.markers.SeriesMarkers;

/**
 * BlockMapPrinterTest:
 * @author zhangxuhai
 * @date 2019/11/6
*/
public class XChartTest {
    @Test
    public void should_print_point_map() throws InterruptedException {
        XYChart chart = new XYChartBuilder()
                .height(30).width(30)
                .title("Test").xAxisTitle("X").yAxisTitle("Y")
                .build();

        chart.getStyler().setDefaultSeriesRenderStyle(XYSeries.XYSeriesRenderStyle.Scatter);
        chart.addSeries("Test Point A", new int[]{1, 10, 23, 5}, new int[]{8, 5, 17, 27}).setMarker(SeriesMarkers.CIRCLE);
        chart.addSeries("Test Point B", new int[]{3, 7, 13, 15}, new int[]{6, 11, 23, 19}).setMarker(SeriesMarkers.CROSS);

        new SwingWrapper<>(chart).displayChart();
    }
}
