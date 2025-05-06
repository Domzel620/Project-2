package Part3_DominicZelinskysHashMapFolder;

import java.util.ArrayList;

public class PokemonHasher {
    private DominicZelinskyHashMap<String> pokeMap;
    public PokemonHasher(){
        pokeMap = new DominicZelinskyHashMap<>();
    }
    
    public DominicZelinskyHashMap<String> hashPokemon(ArrayList<String[]> pokemonSet){//Method for adding pokemon arraylist into custom hashmap
        pokeMap.resize(pokemonSet.size());//Sets the size of the hashmap tothe size of the arraylist
        for(String[] pokemonInfo : pokemonSet){//Loops through the arraylist
            String pokemon = pokemonInfo[0] + " | " + pokemonInfo[1] + " | " + pokemonInfo[2];//Condenses all of the items within the array into one string, only taking the necessary info from the arraylist
            pokeMap.put(pokemon);//Adds that string into custom hashmap
        }
        return pokeMap;
    }
}
