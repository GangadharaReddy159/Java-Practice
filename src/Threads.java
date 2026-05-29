import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;

class MyThread {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread();
        Thread t2 = new Thread();

        t1.start(); //main thread starts executing t1
        t1.join(); //main thread waits for t1 to finish before starting t2

        t2.start(); //main thread starts executing t2 after t1 finishes
        t2.join(1000); //main thread waits for t2 to finish for up to 1 second, then continues even if t2 is still running

        System.out.println("Main thread finished");

        String s = "programming";
        stream(s.split("")).collect(Collectors.groupingBy(c -> c, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(f -> f.getValue() > 1)
                .map(Map.Entry::getKey)
                .forEach(System.out::println);
        String repeated = "aabbcddddeee";
        String nonrepeated = stream(repeated.split("")).collect(Collectors.groupingBy(r -> r, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(c -> c.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst().orElse(null);

        System.out.println(nonrepeated);

        MyClass hero = new MyClass(1, "Venkat", List.of("Java", "Python", "C++"));
        System.out.println(hero);

        int[] ones = {1, 2, 2, 1, 1, 2, 3, 1, 1, 1, 4, 5};
        int tempCount = 0;
        int finalCount = 0;
        //find the max count of consecutive 1s in the array
        for (int i = 0; i < ones.length; i++) {
            if (ones[i] == 1) {
                tempCount++;
            } else {
                finalCount = Math.max(finalCount, tempCount);
                tempCount = 0;
            }
        }
        finalCount = Math.max(finalCount, tempCount);
        System.out.println(finalCount);

        int[] duplicate = {1, 1,2};
        int len = duplicate.length;
        Set<Integer> sorted = Arrays.stream(duplicate).boxed().distinct().sorted().collect(Collectors.toSet());
        System.out.println(sorted);
    }
}
