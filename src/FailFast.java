import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class FailFast {
    public static void main(String[] args) {

        Map<String, Integer> nums = new HashMap<>();

        nums.put("one", 1);
        nums.put("two", 2);

        Iterator<String> iterator = nums.keySet().iterator();

        while(iterator.hasNext()){
            System.out.println(iterator.next());
            nums.put("three", 3); // This will cause ConcurrentModificationException
        }
    }
}
