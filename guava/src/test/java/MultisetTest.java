import org.junit.Test;

import java.util.Iterator;
import java.util.Set;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;



/**
 * @author  CarpCap
 */
public class MultisetTest {
    @Test
    public void test(){
        //create a multiset collection
        Multiset<String> multiset = HashMultiset.create();
        multiset.add("a");
        multiset.add("b");
        multiset.add("c");
        multiset.add("d");
        multiset.add("a");
        multiset.add("b");
        multiset.add("c");
        multiset.add("b");
        multiset.add("b");
        multiset.add("b");

        //打印元素的出现
        System.out.println("Occurrence of 'b' : "+multiset.count("b"));
        //打印multiset总长度
        System.out.println("Total Size : "+multiset.size());
        //获取多重集的不同元素作为集合
        Set<String> set = multiset.elementSet();
        //显示集合的元素
        System.out.println("Set [");
        for (String s : set) {
            System.out.println(s);
        }


        System.out.println("]");
        //display all the elements of the multiset using iterator
        Iterator<String> iterator  = multiset.iterator();
        System.out.println("MultiSet [");
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("]");


        //display the distinct elements of the multiset with their occurrence count
        System.out.println("MultiSet2 [");
        for (Multiset.Entry<String> entry : multiset.entrySet())
        {
            System.out.println("Element: "+entry.getElement() +", Occurrence(s): " + entry.getCount());
        }
        System.out.println("]");

        //remove extra occurrences
        multiset.remove("b",2);
        //print the occurrence of an element
        System.out.println("Occurence of 'b' : "+multiset.count("b"));


    }
}
