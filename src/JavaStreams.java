import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;

public class JavaStreams {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        String[] words = {"Hello", "World", "Java", "Streams"};

        stream(nums).forEach(System.out::println);
        List<String> UpdatedWords= stream(words).sorted(Comparator.comparing(s->s.charAt(1))).collect(Collectors.toList());
        System.out.println(UpdatedWords);

        String[] names = {"Alice", "Bob", "Charlie", "David", "Eve", "Frank"};
        List<String> UpdatedNames = stream(names).sorted(Comparator.comparing(s->s.length())).collect(Collectors.toList());
        System.out.println(UpdatedNames);

        //sort names in descending order of length
        List<String> DescendingNames = stream(names).sorted(Comparator.comparing(String::length).reversed()).collect(Collectors.toList());
        System.out.println(DescendingNames);

    }
}
