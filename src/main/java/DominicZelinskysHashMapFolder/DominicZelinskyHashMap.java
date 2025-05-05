package DominicZelinskysHashMapFolder;

import java.util.LinkedList;

public class DominicZelinskyHashMap<E> {
    private LinkedList<E>[] data;

    public DominicZelinskyHashMap(){
        
        data = (LinkedList<E>[]) new LinkedList[10];
    }

    public int dumbHash(String name){
        int i = 0;
        for (char c : name.toCharArray()) {
            i += c;
        }
        return i;
    }

    public boolean contains(E item) {
        for (LinkedList<E> value : data) {
            if (value != null && value.contains(item)) {
                return true;
            }
        }
        return false;
    }

    public void resize(int size) {
        LinkedList<E>[] newData = (LinkedList<E>[]) new LinkedList[size];

        // Iterate over the old data array
        for (LinkedList<E> bucket : data) {
            if (bucket != null) {
                for (E item : bucket) {
                    int index = dumbHash(item.toString()) % size;
                    if (newData[index] == null) {
                        newData[index] = new LinkedList<>();
                    }
                    newData[index].add(item);
                }
            }
        }
        
        data = newData;
    }
}
