import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Created by hug.
 */
public class TestRedBlackFloorSet {
    @Test
    public void randomizedTest() {
        AListFloorSet al = new AListFloorSet();
        RedBlackFloorSet rb = new RedBlackFloorSet();
        for (int i = 0; i < 1000000; i++) {
            double random = StdRandom.uniform(-5000,5000);
            al.add(random);
            rb.add(random);
        }
        for (int j = 0; j < 100000; j++){
            double random = StdRandom.uniform(-5000,5000);
                assertEquals(al.floor(random), rb.floor(random), 0.000001);
        }
    }
}
