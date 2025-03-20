
import java.io.IOException;

public class csvTester {
    public static void main(String[] args) throws IOException {
        FunctionPlot function = new FunctionPlot();
        
        function.csvWriter(function.expFunc());
    }
}
