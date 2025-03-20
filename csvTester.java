
import java.io.IOException;

public class csvTester {
    public static void main(String[] args) throws IOException {
        FunctionPlot function = new FunctionPlot();
        Salter salt = new Salter();
        function.csvWriter(function.expFunc(0));
        salt.dataReader("C:\\Users\\domze\\OneDrive\\Desktop\\Plotnotes\\plot.txt");
    }
}
