package JavaPSSFIles;

import java.util.ArrayList;
public class FunctionPlot {
    //This will produce the plot points for the first 25 points of an exponential function
    public ArrayList<double[]> expFunc(double initialX){
        ArrayList<double[]> points = new ArrayList<>();//Creates an arraylist to hold the coordinate points of the function
        double y;
        for(double i = initialX; i < initialX+25; i++){//Loops 25 times to produce 25 pairs of datapoints
            y = Math.exp(i);//Computers y=x^2 for each x value on the graph
            points.add(new double[]{i,y});//Adds the data points into the points arraylist 
        }
        return points;//returns the dataset containing all the data points for y=x^2
    }
    //This is the logarithmic function method
    public ArrayList<double[]> logFunc(double initialX){
        ArrayList<double[]> points = new ArrayList<>();//Creates an arraylist to hold the coordinate points of the function
        double y;
        for(double i = initialX; i < initialX+25; i++){//Finds the first 25 points of the function
            y = Math.log(i);//Computers the function y=log(x)
           points.add(new double[]{i,y});//Adds the data points into the points arraylist
        }
        return points;//returns the dataset containing all the datapoints for y=log(x)
    }

    


}
