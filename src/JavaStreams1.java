import org.w3c.dom.ls.LSOutput;

import java.sql.SQLOutput;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

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
        String str = "Happy weekend";

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

        //reversing a string using reduce
        String reduce = Stream.of(str.split("")).reduce("",(a,b)->b+a);
        System.out.println(reduce);

        //join list of strings with a delimiter
        List<String> words = List.of("Hello", "World", "Java", "Streams");
        String joined = words.stream().collect(Collectors.joining("||"));
        System.out.println(joined);

        //merge 2 lists and remove duplicates
        List<String> list1 = List.of("Alice", "Bob", "Charlie");
        List<String> list2 = List.of("Bob", "David", "Eve");
        List<String> merged = Stream.concat(list1.stream(), list2.stream()).distinct().collect(Collectors.toList());
        System.out.println(merged);

        //find the missing number in array
        int[] arr = {3,0,1,4,5};
        int expectedSum = IntStream.rangeClosed(0, arr.length).sum();
        int actualSum = Arrays.stream(arr).sum();
        int missingNumber = expectedSum - actualSum;
        System.out.println(missingNumber);

        //find the common elements in 2 lists
        List<Integer> l1 = List.of(1,2,3,4,5,6);
        List<Integer> l2 = List.of(4,5,6,7,8,9);
        List<Integer> common = l1.stream().filter(l2::contains).toList();
        System.out.println(common);

        //find the count of highest concurring int 1 in the array
        int[] arr1 = {1,2,3,1,2,1,1,3,4,5};
        int mostFrequent = Arrays.stream(arr1).boxed().collect(Collectors.groupingBy(n->n, Collectors.counting()))
                .entrySet().stream().max(Comparator.comparing(Map.Entry::getValue)).map(Map.Entry::getKey).orElse(null);
        System.out.println(mostFrequent);

        //an array has repeated 0 and 1, find the highest count of consecutive 1s in the array
        int[] arr2 = {1,1,0,1,1,1,0,1,1};
        int maxConsecutiveOnes = 0;
        int currentCount = 0;
        for (int n : arr2) {
            if (n == 1) {
                currentCount++;
                maxConsecutiveOnes = Math.max(maxConsecutiveOnes, currentCount);
            } else {
                currentCount = 0;
            }
        }
        System.out.println(maxConsecutiveOnes);

        //create a list of cities where each city has a city name and population, then find the city with the highest population and print its name.
        List<City> cities = List.of(
            new City("New York", 800000),
            new City("Los Angeles", 400000),
            new City("Chicago", 27000000),
            new City("Houston", 2300000),
            new City("Phoenix", 16000000),
                new City("Vegas", 1000000)
        );

        Map<String, List<City>> catergorizedCities = cities.stream().collect(Collectors.groupingBy(city->{
            if(city.population <= 1000000) return "SMALL";
            else if(city.population > 1000000 && city.population < 10000000) return "MEDIUM";
            else return "LARGE";
        }));

        catergorizedCities.forEach((category, cityList)->{
            System.out.println(category+" "+cityList);
        });

    }
}


