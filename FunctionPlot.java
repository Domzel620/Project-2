import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
public class FunctionPlot {
    //This will produce the plot points for the first 25 points of an exponential function
    public ArrayList<double[]> expFunc(){
        ArrayList<double[]> points = new ArrayList<>();
        double y;
        double x;
        for(int i = 0; i < 25; i++){
            y = Math.exp(i);
            x = i;
            points.add(new double[]{x,y});
        }
        return points;
    }

    public void csvWriter(ArrayList<double[]> plot) throws IOException{
        BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\domze\\OneDrive\\Desktop\\Plotnotes\\plot.txt"));
        for(double[] points : plot){
            writer.append(Arrays.toString(points));
            writer.append("\n");
        }
        writer.close();
    }


}
