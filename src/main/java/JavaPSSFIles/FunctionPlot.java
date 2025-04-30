package JavaPSSFIles;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
public class FunctionPlot {
    //This will produce the plot points for the first 25 points of an exponential function
    public ArrayList<double[]> expFunc(double initialX){
        ArrayList<double[]> points = new ArrayList<>();
        double y;
        for(double i = initialX; i < initialX+25; i++){
            y = Math.exp(i);
            points.add(new double[]{i,y});
        }
        return points;
    }

    public ArrayList<double[]> logFunc(double initialX){
        ArrayList<double[]> points = new ArrayList<>();
        
        for(double i = initialX; i < initialX+25; i++){
           double y = Math.log(i);
           points.add(new double[]{i,y});
        }
        return points;
    }

    public void csvOverWriter(ArrayList<double[]> plot, String fileLocation) throws IOException{
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileLocation, false));
        for(double[] points : plot){
            double x = points[0];
            double y = points[1];
            writer.append("x: " + x + " y: " + y + ",");
            writer.append("\n");
        }
        writer.close();
    }
    public void csvCreator(ArrayList<double[]> plot, String fileLocation) throws IOException{
        File file = new File(fileLocation);
        if(file.exists()){
            System.out.println("Said file already exists!");
        }else{
            System.out.println("Creating new file! Location: " + fileLocation);
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileLocation, false));
        for(double[] points : plot){
            double x = points[0];
            double y = points[1];
            writer.append("x: " + x + " y: " + y + ",");
            writer.append("\n");
        }
        writer.close();
        }
        
    }


}
