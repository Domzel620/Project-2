package Part3_DominicZelinskysHashMapFolder;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class RaceCSVOutput {//Creates a Csv file for the race results for a later graph
    public void raceResults(String racer1, long results1, String racer2, long results2, String filePath, String title) throws IOException{
        BufferedWriter writer = new BufferedWriter(new FileWriter(filePath+ "\\" + title +".csv"));
        writer.append("Maps,Time(ms)" + "\n");//Creates the header
        writer.append(racer1 + "," + results1 + "\n");//Fills in racer 1s statistics
        writer.append(racer2 + "," + results2 + "\n");//Fills in Racer 2s statistics
        writer.close();
    }
}
