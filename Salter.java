import java.io.BufferedReader;
import java.io.FileReader;

public class Salter {
    public void dataReader(String file){
        String line;
        String split = ",";
        
        try (BufferedReader reader = new BufferedReader(new FileReader(file))){
            while((line = reader.readLine()) != null){
                String[] data = line.split(split);
                System.out.println("Data: " + String.join(", ", data));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
