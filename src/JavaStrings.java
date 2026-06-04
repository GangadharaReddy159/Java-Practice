import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;

public class JavaStrings {

    public static void main(String[] args) {

        //reverse a string using string builder
        String s1 = "Advanced";
        String reversed = new StringBuilder(s1).reverse().toString();
        System.out.println("Reversed string----------: " + reversed);

        //find if a string is palindrome using string builder
        String s2 = "madam";
        String reversed2 = new StringBuilder(s2).reverse().toString();
        boolean isPalindrome = s2.equals(reversed2);
        System.out.println("Is palindrome----------: " + isPalindrome);

        //finding the duplicate or repeated characters in a string
        String s3 = "programming";
        List<Character> characters = s3.chars().mapToObj(c->(char)c).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(f->f.getValue()>1)
                .map(Map.Entry::getKey)
                .toList();

        System.out.println(characters);

        Map<Character, Long> charCout = s3.chars().mapToObj(c->(char)c).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(f->f.getValue()>1)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        System.out.println(charCout);

        String greet = "Hello World";
        String r = stream(greet.split(" ")).map(s->new StringBuilder(s).reverse().toString()).collect(Collectors.joining(" "));
        System.out.println(r);
        String r2 = new StringBuilder(greet).reverse().toString();
        System.out.println(r2);

        List<Person> people = List.of(
            new Person("Alice", 30, "New York"),
            new Person("Bob", 25,  "Chicago"),
            new Person("Charlie", 35, "Chicago"),
            new Person("David", 28,  "Houston"),
            new Person("Eve", 32,  "Phoenix"),
            new Person("Frank", 27,  "Philadelphia")
        );

        List<Person> people2 = List.of(
                new Person("Venky", 25, "Vijayawada"),
                new Person("Bablu", 24, "Vijayawada"),
                new Person("Gangadhara", 24, "Vijayawada"),
                new Person("Reddy", 24, "Vijayawada")
        );


        List<List<Person>> totalPeople = List.of(people, people2);

        List<Person> top3People = totalPeople.stream().flatMap(List::stream).sorted((p1, p2) -> Integer.compare(p2.getAge(), p1.getAge())).limit(3).toList();
        System.out.println(top3People);

        String hello = "Welcome to Java Programming!";
        Optional<String> reversed1 = stream(hello.split(" ")).reduce((a, b)->b+" "+a);
        System.out.println(reversed1.orElse(""));

        //find the second highest age of the people in the list
        Optional<Integer> secondHighestAge = totalPeople.stream().flatMap(List::stream).map(Person::getAge).distinct().sorted(Comparator.reverseOrder()).skip(1).findFirst();
        System.out.println(secondHighestAge.orElse(null));

        String[] fruits = {"apple", "avacado", "banana", "beetroot", "grape", "guava"};
        Map<Character, List<String>> filterdFruits = stream(fruits).
                collect(Collectors.groupingBy(s->s.charAt(0)));
        System.out.println(filterdFruits);
        Map<Character, Long> filterdCount = stream(fruits)
                .collect(Collectors.groupingBy(s->s.charAt(0),Collectors.counting()));
        System.out.println(filterdCount);

        Map<String, Long> freqFruits = stream(fruits)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(freqFruits);
    }
}
