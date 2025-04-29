package JavaPSSFIles;

import java.awt.BasicStroke;
import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection; 

public class ChartImgCreator {
    public void lineChartMaker(ArrayList<double[]> dataset,String title) {
        XYSeries data = new XYSeries(title);
        for(double[] coords : dataset){
            data.add(coords[0],coords[1]);
        } 
        XYSeriesCollection baseData = new XYSeriesCollection();
        baseData.addSeries(data);
        JFreeChart scatter = ChartFactory.createXYLineChart(title, "X-Coordinates", "Y-Coordinates", baseData);

        int width = 1000;
        int height = 1500;

        try {
            ChartUtils.saveChartAsPNG(new File("ProjectOutput\\" + title + ".png"), scatter, height, width);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void groupChartMaker(ArrayList<double[]> dataset1, String set1Name, ArrayList<double[]> dataset2, String set2Name ,ArrayList<double[]> dataset3, String set3Name ,String title){
        XYSeries data1 = new XYSeries(set1Name);
        XYSeries data2 = new XYSeries(set2Name);
        XYSeries data3 = new XYSeries(set3Name);
        for(double[] coords : dataset1){
            data1.add(coords[0],coords[1]);
        } 
        for(double[] coords : dataset2){
            data2.add(coords[0],coords[1]);
        }
        for(double[] coords : dataset3){
            data3.add(coords[0],coords[1]);
        }
        XYSeriesCollection groupData = new XYSeriesCollection();
        groupData.addSeries(data1);
        groupData.addSeries(data2);
        groupData.addSeries(data3);

        JFreeChart scatter = ChartFactory.createXYLineChart(title, "X-Coordinates", "Y-Coordinates", groupData, PlotOrientation.VERTICAL, true, true, false);
        XYPlot plot = scatter.getXYPlot();

        XYLineAndShapeRenderer design = new XYLineAndShapeRenderer();
            design.setSeriesPaint(0, Color.black);
            design.setSeriesStroke(0, new BasicStroke(1.0f));
            design.setSeriesPaint(1, Color.orange);
            design.setSeriesStroke(1, new BasicStroke(4.0f));
            design.setSeriesPaint(2, Color.BLUE);
            design.setSeriesStroke(2, new BasicStroke(4.0f));
        plot.setRenderer(design);

        int width = 1000;
        int height = 1500;

        try {
            ChartUtils.saveChartAsPNG(new File("ProjectOutput\\" + title + ".png"), scatter, height, width);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
