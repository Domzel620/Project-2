package JavaPSSFIles;



import java.io.IOException;
import java.util.ArrayList;
;
public class csvTester {
    public static void main(String[] args) throws IOException {
        FunctionPlot function = new FunctionPlot();
        Salter salt = new Salter();
        function.csvOverWriter(function.expFunc(0), "ProjectOutput\\plotOutPut.txt");
        ArrayList<double[]> dataset = salt.dataReader("ProjectOutput\\plotOutPut.txt");
        ArrayList<double[]> parsedData = salt.salter(dataset);
        function.csvCreator(parsedData, "ProjectOutput\\newPlotOutPut");
        ArrayList<double[]> smoothedData = salt.smoother(parsedData, 4);
        function.csvCreator(smoothedData, "ProjectOutput\\smoothedDataOutPut");
    }
}
