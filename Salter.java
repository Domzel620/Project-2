import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Random;
public class Salter {
    public ArrayList<double[]> dataReader(String file){
        ArrayList<double[]> parsedData = new ArrayList<>();
        String line;
        String split = " ";
        
        try (BufferedReader reader = new BufferedReader(new FileReader(file))){
            while((line = reader.readLine()) != null){
                line = line.replace(",", "");
                String[] data = line.trim().split(split);
                if(data.length >= 4 && data[0].equals("x:") && data[2].equals("y:")){
                    double x = Double.parseDouble(data[1]);
                    double y = Double.parseDouble(data[3]);
                    parsedData.add(new double[]{x,y});
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return parsedData;
    }


    public ArrayList<double[]> salter(ArrayList<double[]> dataset){
        Random rand = new Random();
        double bigNumba = 0;
        //This sets the range of the randomly salted y's to the biggest y value in the original dataset and 0;
        for(double[] numbas : dataset){
            double number = numbas[1];
            
            if(number > bigNumba){
                bigNumba = number;
            }
        }
        //This has a 33% chance of changing the y value of the dataset for salting purposes
        for(double[] points : dataset){
            int coin = rand.nextInt(9)+1;
            if(coin <= 3){
                points[1] = rand.nextDouble(bigNumba);
            }
        }
        return dataset;
    }
}
