package core.java;

import java.util.Optional;

import static org.testng.Assert.assertEquals;

/**
 * @author badrikant.soni
 */
public class FlatMapAndMAPTest {

    public static void main(String[] args) {

        Optional<String> s1 = Optional.of("abd");
        Optional<String> s2 = s1.map(String::toUpperCase);
        assertEquals(s1, s2);

        Optional<Optional<String>> s3 = Optional.of(Optional.of("STRING"));
        Optional<Optional<String>> s4 = Optional.of("string").map(s -> Optional.of("STRING"));
        assertEquals(s3, s4);

        Optional<String> s5 = Optional.of("STRING");
        Optional<String> s6 = Optional.of("string").flatMap(s -> Optional.of("STRING"));
        assertEquals(s5, s6);

    }
}
