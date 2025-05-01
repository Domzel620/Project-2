package JavaPSSFIles;

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

    


}
