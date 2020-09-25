import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class FlikTest {
    private Flik a;
    @Test
    public void SameNumber() {
        int i = 0;
        for (int j = 0; i < 500; ++i, ++j) {
            if (!Flik.isSameNumber(i, j)){
                System.out.println(i);
            }
            assertEquals(true, Flik.isSameNumber(i, j));
        }
    }
}


