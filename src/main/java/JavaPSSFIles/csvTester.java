package JavaPSSFIles;



import java.io.IOException;
import java.util.ArrayList;

import ExtraCredit.GraphTitleWindow;

public class csvTester {
    public static void main(String[] args) throws IOException {
        FunctionPlot function = new FunctionPlot();//Creates Objects for the needed classes
        Salter salt = new Salter();
        ChartImgCreator charter = new ChartImgCreator();
        DataHandler handler = new DataHandler();
        //ExtraCredit
        GraphTitleWindow app = new GraphTitleWindow();

        handler.csvOverWriter(function.expFunc(0), "ProjectOutput\\plotOutPut.csv");//Calls the exponent function within he csvOverwriter function and saves it to the inputted file path
        ArrayList<double[]> parsedData = handler.dataReader("ProjectOutput\\plotOutPut.csv");//Sets parsedData to the parsed dataset produced by dataReader

        ArrayList<double[]> saltedSet = salt.salter(parsedData);//Salts the parsed dataset
        handler.csvOverWriter(saltedSet, "ProjectOutput\\newPlotOutPut.csv");//Saves the salted dataset to a csv file at the designated filepath

        ArrayList<double[]> smoothedData = salt.smoother(saltedSet, 4);//Smoothes the salted dataset
        handler.csvOverWriter(smoothedData, "ProjectOutput\\smoothedDataOutPu.csv");//saves the smoothed dataset to a csv file at the designated filepath

        charter.lineChartMaker(parsedData, "BaseDataGraph", "ProjectOutput");//Graphs the parsed dataset and save it as a png at the designated filepath
        charter.groupChartMaker(parsedData, "Base Data", saltedSet, "Salted Data", smoothedData, "Smoothed Data", "PSS Chart", "ProjectOutput");//Graphs all three sets and saves it as a png at the designated filepath

        app.guiGraphTitleWindow();//Runs the interactive graphing gui application
    }
}
