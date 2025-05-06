package StatsLibrary;
public class StatsTester {
    public static void main(String[] args) {
        StatsLibrary stats = new StatsLibrary();
        System.out.println(stats.poisson(4, 2));//Tests Poisson Methods
        System.out.println(stats.chebyshevs(5));//Tests Chebyshevs method
    }
}
