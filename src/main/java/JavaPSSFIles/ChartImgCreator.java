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

    //This method is used to creates a scatter plot using the dataset provided by the user and saves it as a png in the users provided filepath
    public void lineChartMaker(ArrayList<double[]> dataset,String title, String file) {
        XYSeries data = new XYSeries(title);//Creates a series to gold the values of the provided dataset
        for(double[] coords : dataset){//Loops through the provided dataset and adds it to the previously created series
            data.add(coords[0],coords[1]);
        } 
        XYSeriesCollection baseData = new XYSeriesCollection();//Creates a Series Collection for graphing
        baseData.addSeries(data);//adds the data series to the series collection
        JFreeChart scatter = ChartFactory.createXYLineChart(title, "X-Coordinates", "Y-Coordinates", baseData);//Creates a JFree chart variable, Uses the provided title parameter, and baseData series collection to create it.

        int width = 1000;// creates a width and height variable to use for the saved png dimensions
        int height = 1500;

        try {
            ChartUtils.saveChartAsPNG(new File("ProjectOutput\\" + title + ".png"), scatter, height, width);//outputs the previously created chart and saves it to the user inputted filepath
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //this method creates a scatter plot containing three datasets provided by the user and saves it as a PNG in the users provided filepath
    public void groupChartMaker(ArrayList<double[]> dataset1, String set1Name, ArrayList<double[]> dataset2, String set2Name ,ArrayList<double[]> dataset3, String set3Name ,String title, String file){
        XYSeries data1 = new XYSeries(set1Name);//Creates three series for later use
        XYSeries data2 = new XYSeries(set2Name);
        XYSeries data3 = new XYSeries(set3Name);
        for(double[] coords : dataset1){//iterates through the provided datasets and adds them into their respective series
            data1.add(coords[0],coords[1]);
        } 
        for(double[] coords : dataset2){
            data2.add(coords[0],coords[1]);
        }
        for(double[] coords : dataset3){
            data3.add(coords[0],coords[1]);
        }
        XYSeriesCollection groupData = new XYSeriesCollection();//Creates a Collection series and adds the previously created series to it for graphing purposes
        groupData.addSeries(data1);
        groupData.addSeries(data2);
        groupData.addSeries(data3);

        JFreeChart scatter = ChartFactory.createXYLineChart(title, "X-Coordinates", "Y-Coordinates", groupData, PlotOrientation.VERTICAL, true, true, false);//creates a scatter chart using the provided title, and groupData series collection
        XYPlot plot = scatter.getXYPlot();

        XYLineAndShapeRenderer design = new XYLineAndShapeRenderer();//Creates an LineAndShapeRenderer object to allow us to modify the line and shape of the plotted graph
            design.setSeriesPaint(0, Color.black);//Affects the first dataset(In this case base dataset)
            design.setSeriesStroke(0, new BasicStroke(1.0f));
            design.setSeriesPaint(1, Color.orange);//Affects the second dataset(In this case the salted dataset)
            design.setSeriesStroke(1, new BasicStroke(4.0f));
            design.setSeriesPaint(2, Color.BLUE);//Affects the third dataset(In this case the smoothed dataset)
            design.setSeriesStroke(2, new BasicStroke(4.0f));
        plot.setRenderer(design);//Adds the renderer to the plot

        int width = 1000;//Creates a width and height variable for the dimensions of the saved plot
        int height = 1500;

        try {
            ChartUtils.saveChartAsPNG(new File("ProjectOutput\\" + title + ".png"), scatter, height, width);//outputs the previously created chart and saves it to the user inputted filepath
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void groupChartApp(ArrayList<double[]> dataset1, String set1Name, ArrayList<double[]> dataset2, String set2Name ,ArrayList<double[]> dataset3, String set3Name ,String title, String file){
        XYSeries data1 = new XYSeries(set1Name);//Creates three series for later use
        XYSeries data2 = new XYSeries(set2Name);
        XYSeries data3 = new XYSeries(set3Name);
        for(double[] coords : dataset1){//Loops through the provided dataset and adds it to the previously created series
            data1.add(coords[0],coords[1]);
        } 
        for(double[] coords : dataset2){
            data2.add(coords[0],coords[1]);
        }
        for(double[] coords : dataset3){
            data3.add(coords[0],coords[1]);
        }
        XYSeriesCollection groupData = new XYSeriesCollection();//Creates a Collection series and adds the previously created series to it for graphing purposes
        groupData.addSeries(data1);
        groupData.addSeries(data2);
        groupData.addSeries(data3);

        JFreeChart scatter = ChartFactory.createXYLineChart(title, "X-Coordinates", "Y-Coordinates", groupData, PlotOrientation.VERTICAL, true, true, false);//creates a scatter chart using the provided title, and groupData series collection
        XYPlot plot = scatter.getXYPlot();

        XYLineAndShapeRenderer design = new XYLineAndShapeRenderer();//Creates an LineAndShapeRenderer object to allow us to modify the line and shape of the plotted graph
            design.setSeriesPaint(0, Color.black);//Affects the first dataset(In this case base dataset)
            design.setSeriesStroke(0, new BasicStroke(1.0f));
            design.setSeriesPaint(1, Color.orange);//Affects the second dataset(In this case the salted dataset)
            design.setSeriesStroke(1, new BasicStroke(4.0f));
            design.setSeriesPaint(2, Color.BLUE);//Affects the third dataset(In this case the smoothed dataset)
            design.setSeriesStroke(2, new BasicStroke(4.0f));
        plot.setRenderer(design);//Adds the renderer to the plot

        int width = 1000;//Creates a width and height variable for the dimensions of the saved plot
        int height = 1500;

        try {
            ChartUtils.saveChartAsPNG(new File(file + File.separator +title), scatter, height, width);//outputs the previously created chart and saves it, 
                                                                                                    //the user path is not set in this one as the export method in the ChartAppCreator.java class has a more dynamic filepath
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
