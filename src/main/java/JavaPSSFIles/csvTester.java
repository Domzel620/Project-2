package JavaPSSFIles;



import java.io.IOException;
import java.util.ArrayList;

public class csvTester {
    public static void main(String[] args) throws IOException {
        FunctionPlot function = new FunctionPlot();
        Salter salt = new Salter();
        ChartImgCreator charter = new ChartImgCreator();
        ChartAppCreator app = new ChartAppCreator();
        DataHandler handler = new DataHandler();

        handler.csvOverWriter(function.expFunc(0), "ProjectOutput\\plotOutPut.csv");
        ArrayList<double[]> dataset = handler.dataReader("ProjectOutput\\plotOutPut.csv");
        ArrayList<double[]> parsedData = salt.salter(dataset);
        handler.csvCreator(parsedData, "ProjectOutput\\newPlotOutPut.csv");
        ArrayList<double[]> smoothedData = salt.smoother(parsedData, 4);
        handler.csvCreator(smoothedData, "ProjectOutput\\smoothedDataOutPu.csv");
        charter.lineChartMaker(dataset, "BaseDataGraph", "ProjectOutput");
        charter.groupChartMaker(dataset, "Base Data", parsedData, "Salted Data", smoothedData, "Smoothed Data", "PSS Chart", "ProjectOutput");
        app.guiGraphTitleWindow();
    }
}
