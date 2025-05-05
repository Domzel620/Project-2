package StatsLibrary;

public class StatsLibrary {
    public double poisson(int k, double successRate){
        double denominator = 1;
        double numerator = Math.pow(successRate, k) * Math.exp(-successRate);//Calculates the numerator for the poisson formula
        for(int i = 1; i  <= k; i++){//Computes the factorial of k
            denominator = denominator * i;
        }
        double x = numerator/denominator;//Completes the formula
        return x;
    }

    public double chebyshevs(double k){
        double shevs = 0;
        if(k >= 1){//Ensures that there is a valid value for k
            shevs = 1-(1/Math.pow(k, 2));//Computes the Chebyshevs formula
        }else{
            System.out.println("Invalid k value, k must be greater than 1");
        }
        return shevs;

    }
}
