import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;

public class PracticeProblems {
    public static void main(String[] args) {
        //list common characters in two strings
        String s1 = "developer";
        String s2 = "Programmingd";
        Set<String> p1 = stream(s1.split("")).collect(Collectors.toSet());
        Set<String> p2 = stream(s2.split("")).collect(Collectors.toSet());
        List<String> p0 = p1.stream().filter(p2::contains).toList();
        System.out.println(p0);

        //create an array of size 2n and
        // copy the elements of the given array of size n to the first n positions and also to the last n positions
        int[] arr = {1,2,1};
        int[] arr1 = new int[arr.length*2];
        for(int i=0;i<arr.length;i++){
            arr1[i]=arr[i];
            arr1[i+arr.length]=arr[i];
        }
        System.out.println(Arrays.toString(arr1));

        String str = "a2b1y3z1";
        String result = Pattern.compile("(\\D)(\\d+)").matcher(str).results()
                .map(m->m.group(1).repeat(Integer.parseInt(m.group(2)))).collect(Collectors.joining());
        System.out.println(result);
    }
}

