package Part1_JavaPSSFIles;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class DataHandler {
    
    public void csvOverWriter(ArrayList<double[]> plot, String fileLocation) throws IOException{//This method is used to either create or overwrite a csv file
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileLocation, false));
        writer.append("x,y" + "\n");//Creates a header for the file
        for(double[] points : plot){//Loops through the provided dataset
            double x = points[0];
            double y = points[1];
            writer.append(x + "," + y);// writes the x and y values into the file
            writer.append("\n");//goes down to the next line
        }
        writer.close();//closes the writer
    }

    public void csvCreator(ArrayList<double[]> plot, String fileLocation) throws IOException{//This method is used to create a new csv file and prevents the files from being overwriiten
        File file = new File(fileLocation);
        if(file.exists()){//Checks if the file already exists
            System.out.println("Said file already exists!");
        }else{
            System.out.println("Creating new file! Location: " + fileLocation);
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileLocation, false));
            writer.append("x,y" + "\n");//Creates a header for the file
        for(double[] points : plot){//loops through the provided dataset
            double x = points[0];
            double y = points[1];
            writer.append(x + "," + y);// writes the x and y values into the file
            writer.append("\n");//skips down to the next line
        }
        writer.close();//closes the writer
        }
        
    }

    public ArrayList<double[]> dataReader(String file){//This method intakes a csv file and converts it into an Arraylist
        ArrayList<double[]> parsedData = new ArrayList<>();//creates an ArrayList to hold the parsed data of the csv file
        String line;//Creates a line string to be used to store lines from csv file
        String split = ",";//creates a split value equal to "," used to split up a line later in the method
        
        try (BufferedReader reader = new BufferedReader(new FileReader(file))){
            boolean skipHeader = true;//Creates a boolean value used to detect whether or not the header has been passed
            while((line = reader.readLine()) != null){//While loop that continues until there is no more lines to parse throughout the file
                if(skipHeader == true){//Checks if the header has been skipped
                    skipHeader = false;
                    continue;//skips to the next iteration of the loop
                }
                String[] data = line.trim().split(split);//Stores the line into a String array, using the split variable from earlier to split up the x and y values into two separate values
                if(data.length == 2){//checks to make sure the String[] only contains two values
                    double x = Double.parseDouble(data[0]);//Parses the String into the doubles of x and y
                    double y = Double.parseDouble(data[1]);
                    parsedData.add(new double[]{x,y});//Adds the values into the parsedData Arraylist
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return parsedData;//returns the newly parsed data from the CSV in an Arraylist
    }
}
