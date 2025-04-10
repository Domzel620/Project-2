import java.io.*;
import java.util.ArrayList;
public class FunctionPlot {
    //This will produce the plot points for the first 25 points of an exponential function
    public ArrayList<double[]> expFunc(int initialX){
        ArrayList<double[]> points = new ArrayList<>();
        double y;
        for(int i = initialX; i < 25; i++){
            y = Math.exp(i);
            initialX = i;
            points.add(new double[]{initialX,y});
        }
        return points;
    }

    public void csvWriter(ArrayList<double[]> plot, String fileLocation) throws IOException{
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
