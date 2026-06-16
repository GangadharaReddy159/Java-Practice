import java.util.*;
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
        String result = Pattern.compile("([a-z])(\\d+)").matcher(str).results()
                .map(m->m.group(1).repeat(Integer.parseInt(m.group(2)))).collect(Collectors.joining());
        System.out.println(result);

        String str1 = "3[ab]2[xyz]";
        String result1 = Pattern.compile("(\\d+)\\[([a-z]+)\\]").matcher(str1).results()
                .map(m->m.group(2).repeat(Integer.parseInt(m.group(1)))).collect(Collectors.joining());
        System.out.println(result1);

        String b = "dbace";
        String s = stream(b.split("")).sorted().collect(Collectors.joining());
        System.out.println(s);


        int[] nums = {1,2,2,3,3,3};
        int k =2;
        Map<Integer, Integer> mapR = new HashMap<>();
        for(int i:nums) {
            mapR.put(i, mapR.getOrDefault(i, 0) + 1);
        }
        int[] result2 = mapR.entrySet().stream().sorted(Comparator.comparing(Map.Entry::getValue, Comparator.reverseOrder()))
                .limit(k)
                .mapToInt(Map.Entry::getKey)
                .toArray();
        System.out.println(Arrays.toString(result2));

        String slash = "3#abc";
        int slashIndex = slash.indexOf("#",0);
        System.out.println(slashIndex);

        int[] kth = {1,2,3,4,5};
        //sort the array in descending order

    }
}

