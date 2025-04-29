package JavaPSSFIles;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection; 

public class ChartCreator {
    public void lineChartMaker(ArrayList<double[]> dataset,String title) throws IOException {
        XYSeries data = new XYSeries(title);
        for(double[] coords : dataset){
            data.add(coords[0],coords[1]);
        } 
        XYSeriesCollection baseData = new XYSeriesCollection();
        baseData.addSeries(data);
        JFreeChart scatter = ChartFactory.createXYLineChart(title, "X-Coordinates", "Y-Coordinates", baseData);

        int width = 1000;
        int height = 1500;

        ChartUtils.saveChartAsPNG(new File("ProjectOutput\\" + title + ".jpeg"), scatter, height, width);
    }
}
