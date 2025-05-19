import com.google.common.base.Optional;
import org.junit.Test;

/**
 * @author  CarpCap
 */
public class OptionalTest {

    @Test
    public void test() {
        System.out.println(Optional.fromNullable("1").or("2"));
        System.out.println(Optional.fromNullable(null).or("2"));


        Integer value1 = null;
        Integer value2 = new Integer(10);
        //Optional.fromNullable - allows passed parameter to be null.
        Optional<Integer> a = Optional.fromNullable(value1);
        //Optional.of - throws NullPointerException if passed parameter is null
        Optional<Integer> b = Optional.of(value2);
        System.out.println(sum(a, b));

        //or method  use
        Integer value3 = new Integer(10);
        java.util.Optional<Integer> c = java.util.Optional.ofNullable(null);
        System.out.println(c.orElse(53454));

    }

    public static Integer sum(Optional<Integer> a, Optional<Integer> b) {
        //Optional.isPresent - checks the value is present or not
        System.out.println("First parameter is present: " + a.isPresent());

        System.out.println("Second parameter is present: " + b.isPresent());

        //Optional.or - returns the value if present otherwise returns
        //the default value passed.
        Integer value1 = a.or(new Integer(0));

        //Optional.get - gets the value, value should be present
        Integer value2 = b.get();

        return value1 + value2;
    }
}
