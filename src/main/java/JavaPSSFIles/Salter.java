package JavaPSSFIles;

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
        ArrayList<double[]> salted = new ArrayList();
        double bigNumba = 0;
        for(double[] coords : dataset){
            double x = coords[0];
            double y = coords[1];
            salted.add(new double[]{x,y});
        }
        //This sets the range of the randomly salted y's to the biggest y value in the original dataset and 0;
        for(double[] numbas : salted){
            double number = numbas[1];

            if(number > bigNumba){
                bigNumba = number;
            }
        }
        //This has a 33% chance of changing the y value of the dataset for salting purposes
        for(double[] points : salted){
            int coin = rand.nextInt(9)+1;
            if(coin <= 3){
                points[1] = rand.nextDouble(bigNumba);
            }
        }
        return salted;
    }

    public ArrayList<double[]> smoother(ArrayList<double[]> dataset, int windowValue){
        ArrayList<double[]> newSet = new ArrayList<>();
        for(double[] coords : dataset){
            double x = coords[0];
            double y = coords[1];
            newSet.add(new double[]{x,y});
        }

        int count = 0;
        int length = dataset.size()-1;
        for(double[] points : dataset){
            double sum = 0;
            int counter = 0;
            int max = count+windowValue;
            int min = count-windowValue;
            if(min >= 0 && max <= length){
                for(int i = min; i <= max; i++){
                    sum += dataset.get(i)[1];
                    counter++;
                }
            }else if(count >= windowValue && max > length){
                for(int i = min; i <= length; i++){
                    sum += dataset.get(i)[1];
                    counter++;
                }
            }else if( min < 0 && max <= length){
                for(int i = 0; i <= max; i++){
                    sum += dataset.get(i)[1];
                    counter++;
                }
            } else if(min < 0 && max > length){
                for(int i = 0; i <= length; i++){
                    sum += dataset.get(i)[1];
                    counter++;
                }
            }
            double average = sum/counter;
            newSet.get(count)[1] = average;
            count++;
        }
        return newSet;
    }
}
