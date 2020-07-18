package stream;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author badrikant.soni
 * Link : https://www.geeksforgeeks.org/stream-in-java/#:~:text=A%20stream%20is%20a%20sequence,Arrays%20or%20I%2FO%20channels.
 *
 * A stream is a sequence of objects that supports various methods which can be pipelined to produce the desired result.
 * The features of Java stream are –
 *
 * A stream is not a data structure instead it takes input from the Collections, Arrays or I/O channels.
 *
 * Streams don’t change the original data structure, they only provide the result as per the pipelined methods.
 *
 * Each intermediate operation is lazily executed and returns a stream as a result,
 * hence various intermediate operations can be pipelined. Terminal operations mark the end of the stream and return the result.
 */
public class UnderstandStream {

    public static void main(String args[])
    {

        // create a list of integers
        List<Integer> number = Arrays.asList(2,3,4,5);

        // demonstration of map method
        List<Integer> square = number.stream().map(x -> x*x).
                collect(Collectors.toList());
        System.out.println(square);

        // create a list of String
        List<String> names =
                Arrays.asList("Reflection","Collection","Stream");

        // demonstration of filter method
        List<String> result = names.stream().filter(s->s.startsWith("S")).
                collect(Collectors.toList());
        System.out.println(result);

        // demonstration of sorted method
        List<String> show =
                names.stream().sorted().collect(Collectors.toList());
        System.out.println(show);

        // create a list of integers
        List<Integer> numbers = Arrays.asList(2,3,4,5,2);

        // collect method returns a set
        Set<Integer> squareSet =
                numbers.stream().map(x->x*x).collect(Collectors.toSet());
        System.out.println(squareSet);

        // demonstration of forEach method
        number.stream().map(x->x*x).forEach(y->System.out.println(y));

        // demonstration of reduce method
        int even =
                number.stream().filter(x->x%2==0).reduce(0,(ans,i)-> ans+i);

        System.out.println(even);
    }
}
