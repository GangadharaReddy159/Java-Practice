import java.util.Map;
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
        stream(s.split("")).collect(Collectors.groupingBy(c->c, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(f->f.getValue()>1)
                .map(Map.Entry::getKey)
                .forEach(System.out::println);
        String repeated = "aabbcddddeee";
        String nonrepeated = stream(repeated.split("")).collect(Collectors.groupingBy(r->r, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(c->c.getValue()==1)
                .map(Map.Entry::getKey)
                .findFirst().orElse(null);

        System.out.println(nonrepeated);

    }
}
