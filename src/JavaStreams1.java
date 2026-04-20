import org.w3c.dom.ls.LSOutput;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class JavaStreams1 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6};
        List<Integer> numList = List.of(0,2,4,5);

        int [] nums1 = {1,2,1,2,5,8};

        int sum = Arrays.stream(nums).sum();
        System.out.println(sum);

        //finding the list of missing numbers
        int length = numList.size();
        List<Integer> missingNum = IntStream.rangeClosed(0,length).filter(n->!numList.contains(n)).boxed().toList();
        System.out.println(missingNum);

        List<String> names = List.of("Alice", "Bob", "Charlie", "David", "Eve", "Frank");

        //sorting the list based on second character of string

        List<String> sortedNames = names.stream().sorted(Comparator.comparing(s->s.charAt(1))).collect(Collectors.toList());
        System.out.println(sortedNames);

        String random = "programming";

        //finding the first repeating character in the string
        Character firstRepeating = random.chars(). mapToObj(c->(char)c)
                .filter(c->random.indexOf(c)!=random.lastIndexOf(c)).findFirst().orElse(null);
        System.out.println(firstRepeating);

        //finding the first non-repeating character in the string
        Character firstNonRepeating = random.chars(). mapToObj(c->(char)c)
                .filter(c->random.indexOf(c)==random.lastIndexOf(c)).findFirst().orElse(null);
        System.out.println(firstNonRepeating);

        //finding all missing numbers in the array
        int max = Arrays.stream(nums1).max().orElse(0);
        int min = Arrays.stream(nums1).min().orElse(0);
        Set<Integer> dNums = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
        List<Integer> missingNums = IntStream.rangeClosed(min, max).filter(n->!dNums.contains(n)).boxed().toList();
        System.out.println(missingNums);

    }
}
