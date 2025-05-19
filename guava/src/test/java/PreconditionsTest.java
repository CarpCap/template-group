import com.google.common.base.Preconditions;
import org.junit.Test;

/**
 * @author  CarpCap
 */
public class PreconditionsTest {


    @Test
    public void simple(){
        Preconditions.checkArgument(false);
    }

    @Test
    public void test1(){
        int i =-1;
        Preconditions.checkArgument(i>=0, "Argument was %s but expected nonnegative", i);
    }

    @Test
    public void checkState(){
        Preconditions.checkState(true);
    }

    @Test
    public  void test(){
        try {
            System.out.println(sqrt(-3.0));
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
        try {
            System.out.println(sum(null,3));
        }catch(NullPointerException e){
            System.out.println(e.getMessage());
        }
        try {
            System.out.println(getValue(4));
        }catch(IndexOutOfBoundsException e){
            System.out.println(e.getMessage());
        }
    }


    public static double sqrt(double input) throws IllegalArgumentException {
        Preconditions.checkArgument(input > 0.0,
                "Illegal Argument passed: Negative value %s.", input);
        return Math.sqrt(input);
    }

    public static int sum(Integer a, Integer b){
        a = Preconditions.checkNotNull(a,
                "Illegal Argument passed: First parameter is Null.");
        b = Preconditions.checkNotNull(b,
                "Illegal Argument passed: Second parameter is Null.");
        return a+b;
    }

    public static int getValue(int input){
        int[] data = {1,2,3,4,5};
        Preconditions.checkElementIndex(input,data.length,
                "Illegal Argument passed: Invalid index.");
        return 0;
    }
}
