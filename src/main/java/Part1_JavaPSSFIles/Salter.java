package Part1_JavaPSSFIles;

import java.util.ArrayList;
import java.util.Random;
public class Salter {
    


    public ArrayList<double[]> salter(ArrayList<double[]> dataset){
        Random rand = new Random();
        ArrayList<double[]> salted = new ArrayList();//creates an arraylist to hold salted values
        double bigNumba = 0;//This number is used to store the value of the biggest number in the dataset
        for(double[] coords : dataset){//loops through the provided dataset and adds it to the salted arraylist
            double x = coords[0];
            double y = coords[1];
            salted.add(new double[]{x,y});
        }
        
        for(double[] numbas : salted){//This sets the range of the randomly salted y's to the biggest y value in the original dataset and 0;
            double number = numbas[1];

            if(number > bigNumba){
                bigNumba = number;
            }
        }
        
        for(double[] points : salted){//This has a 33% chance of changing the y value of the dataset for salting purposes
            int coin = rand.nextInt(9)+1;
            if(coin <= 3){
                points[1] = rand.nextDouble(bigNumba);//assigns this datapoint to a random number between 0 and bigNumba
            }
        }
        return salted;//Returns the salted Arraylist dataset
    }

    public ArrayList<double[]> smoother(ArrayList<double[]> dataset, int windowValue){
        ArrayList<double[]> newSet = new ArrayList<>();//Creates a new arraylist to hold the smoothed dataset
        for(double[] coords : dataset){//loops through the provided dataset and puts it into the new arraylist
            double x = coords[0];
            double y = coords[1];
            newSet.add(new double[]{x,y});
        }

        int count = 0;//creates a count integer to count to create a maximum and minimum value with
        int length = dataset.size()-1;//creates a length variable using the dataset size
        for(double[] points : dataset){//Loops through the entire dataset and smoothes out the data
            double sum = 0;
            int counter = 0;//creates a counter variable to find the average, the reason this is used rather than the count variable is due to if statements below.
            int max = count+windowValue;//Creates a maximum and minimum value using the counter and windowValue
            int min = count-windowValue;
            if(min >= 0 && max <= length){//This case is run when the window value fits within the size of the arraylist
                for(int i = min; i <= max; i++){
                    sum += dataset.get(i)[1];//sets sum equal to the current sum + the the dataset value in position i
                    counter++;
                }
            }else if(count >= windowValue && max > length){//This case is run when the window value is greater than the bounds of the array
                for(int i = min; i <= length; i++){
                    sum += dataset.get(i)[1];//sets sum equal to the current sum + the the dataset value in position i
                    counter++;
                }
            }else if( min < 0 && max <= length){//This case is run when the window value is lesser than the bounds of the array
                for(int i = 0; i <= max; i++){
                    sum += dataset.get(i)[1];//sets sum equal to the current sum + the the dataset value in position i
                    counter++;
                }
            } else if(min < 0 && max > length){//This value is run when the window value is both greater and lesser than the bounds of the array
                for(int i = 0; i <= length; i++){
                    sum += dataset.get(i)[1];//sets sum equal to the current sum + the the dataset value in position i
                    counter++;
                }
            }
            double average = sum/counter;//Finds the mean average of sum and the counter(amount of values added into sum)
            newSet.get(count)[1] = average;//sets the value of the current points[1] to the average of the windowvalue
            count++;
        }
        return newSet;//Returns the Smoothed Arraylist
    }
}
