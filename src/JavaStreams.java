import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;

public class JavaStreams {
    public static <Employee> void main(String[] args) {
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

        List<String> myNames = List.of("venkat", "Bablu", "Gangadhara", "Reddy");
        List<String> sortedOnSecondChar = myNames.stream().sorted(Comparator.comparing(s->s.charAt(1))).collect(Collectors.toList());
        System.out.println(sortedOnSecondChar);

        //create a list of 6 employees with name, age, salary and city, then sort them by age and print the sorted list.
        List<Person> employees = List.of(
            new Person("Alice", 30, "New York"),
            new Person("Bob", 25,  "Los Angeles"),
            new Person("Charlie", 35, "Chicago"),
            new Person("David", 28,  "Houston"),
            new Person("Eve", 32,  "Phoenix"),
            new Person("Frank", 27,  "Philadelphia")
        );

        double avgAge = employees.stream().mapToInt(Person::getAge).average().orElse(0);
        System.out.println("Average Age: "+avgAge);

        Map<String, Long> employeeByCity = employees.stream().collect(Collectors.groupingBy(Person::getCity, Collectors.counting()));
        System.out.println("Employees by City: "+employeeByCity);

        Map<String, List<Person>> employeesByCity = employees.stream().collect(Collectors.groupingBy(Person::getCity, Collectors.toList()));
        System.out.println("Employees by City: "+employeesByCity);

    }
}
