package Part3_DominicZelinskysHashMapFolder;

import java.util.LinkedList;

public class DominicZelinskyHashMap<E> {
    private LinkedList<E>[] data;
    private int collisionCounter;

    public DominicZelinskyHashMap(){
        
        data = (LinkedList<E>[]) new LinkedList[1000];
        collisionCounter = 0;
    }

    public int dumbHash(String name){//This methods sums the values of characters in the inputed string
        int i = 0;
        for (char c : name.toCharArray()) {
            i += c;
        }
        return i;
    }

    public boolean contains(E item) {
        for (LinkedList<E> value : data) {//Iterates through the bucket
            if (value != null && value.contains(item)) {//Checks to make sure the value isn't null, and if it contains the item
                return true;
            }
        }
        return false;
    }

    public void resize(int size) {//Resizes the hash map with the inputed size
        LinkedList<E>[] newData = (LinkedList<E>[]) new LinkedList[size];

        for (LinkedList<E> list : data) {
            if (list != null) {
                for (E item : list) {//Loop that rehashes all items into new positions relative to the new size
                    int index = dumbHash(item.toString()) % size;//Resets the index with the new size
                    if (newData[index] == null) {
                        newData[index] = new LinkedList<>();//Creates the buckets
                    }
                    newData[index].add(item);//adds it to the new bucket
                } 
            }
        }
        
        data = newData;
    }

    public int size(){//Iterates through the buckets creating a sum equal to the size of the hashmap
        int size = 0;
        for(LinkedList<E> list : data){
            if(list != null){//Ensures it avoids null buckets
                size += list.size();
            }
        }
        return size;
    }

    public void put(E item){//Puts an inputed item into the hashmap
        int index = dumbHash(item.toString())% data.length;
        if(index < 0){//Ensures the index isn't negative
            index += data.length;
        }
        if(data[index] == null){//This check creates a new bucket if it is needed
            data[index] = new LinkedList<>();
        } 
        if(!data[index].contains(item)){//Ensures that there are no duplicates
            if(!data[index].isEmpty()){//If an item is already in the bucket it increases the collision counter
                collisionCounter++;
            }
            data[index].add(item);//Puts the item into the hashmap
        }
    }

    public E get(E item){
        int index = dumbHash(item.toString()) % data.length;
        E grabbed = null;//Sets grabbed to null incase the item isn't in the bucket
        if(index < 0){//ensures the index isn't negative
            index += data.length;
        }
        if(data[index] != null){//Checks to make sure the index isn't null
            for(E search : data[index]){
                if(search.equals(item)){
                    grabbed = search;//sets grabbed to the matching item, breaking the loop
                    break;
                }
            }
        }
        return grabbed;
        
    }
    public void remove(E item){
        int index = dumbHash(item.toString()) % data.length;
        if(index < 0){//Ensures the index isn't negative
            index += data.length;
        }
        if(data[index] != null){//Makes sure the index isn't null
            data[index].remove(item);//Removes the item
        }
    }

    public int getCollisions(){//Returns the total collisions
        return collisionCounter;
    }
}
