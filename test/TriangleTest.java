import org.junit.jupiter.api.*;

import java.util.List;

public class TriangleTest {

    @Test
    public void coordinatesTest() {
        String testString = "-5 -5 14 -5 -5 14";
        List<Integer> collection = Triangle.coordinates(testString);
        Assertions.assertEquals(6, collection.size());
    }

    @Test
    public void coordinatesTest_Exception() {
        String testString = "-5 14 -5 -5 14";
        List<Integer> collection = Triangle.coordinates(testString);
        Assertions.assertEquals(0, collection.size());
    }

    @Test
    public void squareTest(){
        String testString = "-5 -5 14 -5 -5 14";
        List<Integer> collection = Triangle.coordinates(testString);
        double d = Triangle.square(collection);
        Assertions.assertEquals(180.5, d);
    }
}
