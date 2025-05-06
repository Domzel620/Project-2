package DominicZelinskysHashMapFolder;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class PokemonReader {
    public ArrayList<String[]> readPokemonCSV(String filePath){
        ArrayList<String[]> parsedData = new ArrayList<>();
        String line;
        String split = ",";

        try(BufferedReader reader = new BufferedReader(new FileReader(filePath))){
            boolean skipHeader = true;
            while((line = reader.readLine()) != null){
                if(skipHeader == true){//If statment to ensure the header isn't added into the arraylist
                    skipHeader = false;
                    continue;
                }
                String[] data = line.trim().split(split);
                if(data.length == 5){//Checks to make tsure the data[] is the correct size
                    String pokemon = data[0];
                    String cardType = data[1];
                    String generation = data[2];
                    String cardNumber = data[3];
                    String price = data[4];
                    parsedData.add(new String[]{pokemon, cardType, generation, cardNumber, price});//adds all categories into the arraylist
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return parsedData;
    }
}
