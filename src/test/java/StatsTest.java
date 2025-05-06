
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import StatsLibrary.StatsLibrary;

public class StatsTest {

    @Test
    public void testCheby(){//Tests to make sure Chebyshevs method produces correct outputs
        StatsLibrary stats = new StatsLibrary();
        double expected = 0.96;
        double actual = stats.chebyshevs(5);
        assertEquals(expected, actual, "Testing Chebyshevs Theorem: ");
    }

    @Disabled//Disabled incorrect test that was used to check what happens when a maven test has a failure
    public void testChebyFail(){
        StatsLibrary stats = new StatsLibrary();
        double expected = 0.5;
        double actual = stats.chebyshevs(5);
        assertEquals(expected, actual);
    }

    @Test
    public void testPoisson(){//Ensures Poisson method produces correct outputs
        StatsLibrary stats = new StatsLibrary();
        double expected = 0.14652511110987343;
        double actual = stats.poisson(2, 4);
        assertEquals(expected, actual);
    }
}
