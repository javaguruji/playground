package core.java;

import lombok.Data;

import java.util.Optional;

/**
 * @author badrikant.soni
 *
 *  Objective :
 *  1. Help writing neat code without using too many null checks.
 *  2. By using Optional, we can specify alternate values to return or alternate code to run.
 *
 *  What is Optional Class - Optional is a container object used to contain not null objects.
 *  Optional object is used to represet null with absent value.
 *  This class has various utility methods to facilitate code to handle values as ‘available’ or ‘not available’ instead of checking null values.
 *
 *  Optional.ofNullable - allows passed parameter to be null.
 *  Optional.of - throws NullPointerException if passed parameter is null
 *  Optional.isPresent - checks the value is present or not
 *  Optional.orElse - returns the value if present otherwise returns the default value passed.
 *  Optional.get - gets the value, value should be present.
 *  Optional.orElseGet() - return the value if present in optional container , otherwise value generated from the specified supplier.
 *
 */
public class OptionalTest {

    public static void main(String[] args) {

        Integer value1 = null;
        Integer value2 = 10;

        Optional<Integer> a1 = Optional.ofNullable(value1); // allow to pass null value, return empty optional instance
        Optional<Integer> a2 = Optional.of(value2); // throws NPE if passed value is null

        System.out.println(sumNumbers(a1, a2));


        int v = (int)Math.random() * 10;  // v = 0
        System.out.println("v = " + v);

        // create a Optional
        Optional<Integer> op
                = Optional.empty();

        // print supplier
        System.out.println("Optional: "
                + op);

        // orElseGet supplier
        System.out.println("Value by orElseGet"
                + "(Supplier) method: "
                + op.orElseGet(
                () -> (int)(Math.random() * 10)));


        int appMarketPlaceId = Optional.ofNullable(new AdGroup()).map(AdGroup::getAppMarketPlaceId).orElse(1);
        System.out.println("appMarketPlaceId : " + appMarketPlaceId);


    }

    private static Integer sumNumbers(Optional<Integer> a1, Optional<Integer> a2) {
        System.out.println(a1.isPresent()); // if value is present in optional container, return false
        System.out.println(a2.isPresent()); // if value is present in optional container, return true

        // returns the value if present otherwise returns the default value(0) which is passed.
        // if value present in a1 optional object, then return the same else return the passed value which is 0 in this case.
        Integer value1 = a1.orElse(0);
        System.out.println("value1 : " + value1);

        Integer value2 = a2.get(); // returns the value if its present in a2, otherwise return NPE, it doesn't check isPresent
        System.out.println("value2 : " + value2);

        return value1 + value2;

    }
}
@Data
class AdGroup{

    Integer appMarketPlaceId;
    String market;

    public AdGroup() {
        this.appMarketPlaceId = null;
        this.market = "market";
    }
}
