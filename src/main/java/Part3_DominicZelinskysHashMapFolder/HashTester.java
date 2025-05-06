package Part3_DominicZelinskysHashMapFolder;


import java.io.IOException;
import java.util.ArrayList;

public class HashTester {
    

    public static void main(String[] args) throws IOException {//Tester class for CustomHashmap classes
        HashRace race = new HashRace();
        PokemonReader pokeReader = new PokemonReader();
        PokemonHasher pokeHasher = new PokemonHasher();
        DominicZelinskyHashMap<String> domsHashMap = new DominicZelinskyHashMap<>();
        ArrayList<String[]> pokeArray = new ArrayList<>();
        race.hashRace("Part-2Contents\\pokemon_cards.csv");

        
        pokeArray = pokeReader.readPokemonCSV("Part-2Contents\\pokemon_cards.csv");
        domsHashMap = pokeHasher.hashPokemon(pokeArray);
        System.out.println(domsHashMap.getCollisions() + " PokeHash Collisions");
    }
}
