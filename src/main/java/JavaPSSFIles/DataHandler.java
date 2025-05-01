package JavaPSSFIles;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class DataHandler {
    
    public void csvOverWriter(ArrayList<double[]> plot, String fileLocation) throws IOException{
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileLocation, false));
        writer.append("x,y" + "\n");
        for(double[] points : plot){
            double x = points[0];
            double y = points[1];
            writer.append(x + "," + y);
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
            writer.append("x,y" + "\n");
        for(double[] points : plot){
            double x = points[0];
            double y = points[1];
            writer.append(x + "," + y);
            writer.append("\n");
        }
        writer.close();
        }
        
    }

    public ArrayList<double[]> dataReader(String file){
        ArrayList<double[]> parsedData = new ArrayList<>();
        String line;
        String split = ",";
        
        try (BufferedReader reader = new BufferedReader(new FileReader(file))){
            boolean skipHeader = true;
            while((line = reader.readLine()) != null){
                if(skipHeader == true){
                    skipHeader = false;
                    continue;
                }
                String[] data = line.trim().split(split);
                if(data.length == 2){
                    double x = Double.parseDouble(data[0]);
                    double y = Double.parseDouble(data[1]);
                    parsedData.add(new double[]{x,y});
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return parsedData;
    }
}
