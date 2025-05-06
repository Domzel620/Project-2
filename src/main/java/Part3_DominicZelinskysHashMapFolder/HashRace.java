package Part3_DominicZelinskysHashMapFolder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class HashRace {
    public void hashRace(String filePath) throws IOException{
        ArrayList<String[]> fans = new ArrayList();
        PokemonReader evaluatedPokemon = new PokemonReader();
        PokemonHasher pokeHasher = new PokemonHasher();
        HashMap<String, Integer> hash = new HashMap<>();
        RaceCSVOutput results = new RaceCSVOutput();
        fans = evaluatedPokemon.readPokemonCSV(filePath);//Sets the Arraylist used equal to the Pokemon csv/whatever csv is being input
        
        long pokeHashTimeStart = System.nanoTime();//Start timer for custom hashmap
            pokeHasher.hashPokemon(fans);
        long pokeHashTimeEnd = System.nanoTime();//End timer
        long pokeHashTime = pokeHashTimeEnd - pokeHashTimeStart;//Finds the difference for time in nanoseconds
        pokeHashTime = pokeHashTime/1000000;//sets time to miliseconds

        long hashTimeStart = System.nanoTime();//Start timer for Java HashMap
        int count = 0;
            for(String[] items : fans){//iterates through the arraylist and adds items into hashmap
                String stuff = items[0] + " | " + items[1] + " | " + items[2];
                hash.put(stuff, count);
                count++;
            }
        long hashTimeEnd = System.nanoTime();//End TImer
        long hashTime = hashTimeEnd - hashTimeStart;//Finds the difference for time in nanoseconds
        hashTime = hashTime/1000000;//sets time to miliseconds

        System.out.println("The Pokemon Hasher took " + pokeHashTime + " miliseconds to put the Arraylist into the Custom HashMap");//outputs comparison
        System.out.println("The Java HashMap took " + hashTime + " miliseconds to putthe ArrayList into the official Java HashMap");
        results.raceResults("Doms Custom Map", pokeHashTime, "Java HashMap", hashTime, "ProjectOutput\\ProjectPart3", "RaceResults");//Creates CSV for graphing purposes
    }
}
