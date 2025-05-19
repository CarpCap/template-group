import com.google.common.collect.Ordering;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.Test;


/**
 * @author  CarpCap
 */
public class OrderingTest {

    @Test
    public void test(){
        List<Integer> numbers = new ArrayList<Integer>();
        numbers.add(new Integer(5));
        numbers.add(new Integer(2));
        numbers.add(new Integer(15));
        numbers.add(new Integer(51));
        numbers.add(new Integer(53));
        numbers.add(new Integer(35));
        numbers.add(new Integer(45));
        numbers.add(new Integer(32));
        numbers.add(new Integer(43));
        numbers.add(new Integer(16));


        Ordering ordering = Ordering.natural();


        System.out.println("最小值: " + ordering.min(numbers));
        System.out.println("最大值: " + ordering.max(numbers));


        System.out.println("输入内容 List: ");
        System.out.println(numbers);

        Collections.sort(numbers,ordering);
        System.out.println("排序后 List: ");
        System.out.println(numbers);

        System.out.println("======================");
        System.out.println("List 是否 已经排序: " + ordering.isOrdered(numbers));


        Collections.sort(numbers,ordering.reverse());
        System.out.println("倒序 : " + numbers);

        numbers.add(null);
        System.out.println("Null 添加到 Sorted List: ");
        System.out.println(numbers);

        Collections.sort(numbers,ordering.nullsFirst());
        System.out.println("空第一排序列表: ");
        System.out.println(numbers);
        System.out.println("======================");

        List<String> names = new ArrayList<String>();
        names.add("Ram");
        names.add("Shyam");
        names.add("Mohan");
        names.add("Sohan");
        names.add("Ramesh");
        names.add("Suresh");
        names.add("Naresh");
        names.add("Mahesh");
        names.add(null);
        names.add("Vikas");
        names.add("Deepak");

        System.out.println("Another List: ");
        System.out.println(names);

        Collections.sort(names,ordering.nullsFirst().reverse());
        System.out.println("Null first then reverse sorted list: ");
        System.out.println(names);


    }
}
