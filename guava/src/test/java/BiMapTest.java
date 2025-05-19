import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import org.junit.Test;

import java.util.Set;

/**
 * @author  CarpCap
 */
public class BiMapTest {
    @Test
    public void test(){
        BiMap<Integer, String> empIDNameMap = HashBiMap.create();

        empIDNameMap.put(101, "Mahesh1");
        empIDNameMap.put(102, "Sohan");
        empIDNameMap.put(103, "Ramesh");

        empIDNameMap.put(101, "Mahesh");
        empIDNameMap.put(104, "Ramesh");

        System.out.println(empIDNameMap.values());

        BiMap<String, Integer> inverse = empIDNameMap.inverse();

        System.out.println(inverse.values());

        //Emp Id of Employee "Mahesh"
        System.out.println(inverse.get("Mahesh"));
    }
}
