package JavaPSSFIles;



import java.io.IOException;
import java.util.ArrayList;

public class csvTester {
    public static void main(String[] args) throws IOException {
        FunctionPlot function = new FunctionPlot();
        Salter salt = new Salter();
        ChartImgCreator charter = new ChartImgCreator();
        ChartAppCreator app = new ChartAppCreator();

        function.csvOverWriter(function.expFunc(0), "ProjectOutput\\plotOutPut.txt");
        ArrayList<double[]> dataset = salt.dataReader("ProjectOutput\\plotOutPut.txt");
        ArrayList<double[]> parsedData = salt.salter(dataset);
        function.csvCreator(parsedData, "ProjectOutput\\newPlotOutPut.txt");
        ArrayList<double[]> smoothedData = salt.smoother(parsedData, 4);
        function.csvCreator(smoothedData, "ProjectOutput\\smoothedDataOutPu.txt");
        charter.lineChartMaker(dataset, "BaseDataGraph");
        charter.groupChartMaker(dataset, "Base Data", parsedData, "Salted Data", smoothedData, "Smoothed Data", "PSS Chart");
        app.graphApplication( "Test");
    }
}
