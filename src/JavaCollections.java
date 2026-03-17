import java.util.*;

public class JavaCollections {

    public static void main(String[] args) {

        //create 3 arrays of different types
        System.out.println("----Arrays Demonstration----");
        int[] sample = new int[3];
        Arrays.fill(sample, 42);
        System.out.println("Sample array: "+Arrays.toString(sample));
        int[] intArray = {3,1,4,2,5};
        String[] stringArray = {"Hello", "World", "Java"};
        double[] doubleArray = {1.1, 2.2, 3.3};

        for(int i: intArray) System.out.print(i+" ");
        System.out.println(stringArray.length);
        double sum = 0;
        for(double d: doubleArray) sum+=d;
        System.out.println("Sum of double array: "+sum);
        //sort the int array
        Arrays.sort(intArray);
        System.out.println("Sorted int array: "+Arrays.toString(intArray));

        //list

        List list1 = List.of("Hello", 42, 3.14);
        System.out.println("\n----List Demonstration----");
        System.out.println("List: "+list1);
        System.out.println("Size: "+list1.size());
        System.out.println("Element at index 1: "+list1.get(1));
        //list1.add("New Element"); // this will throw UnsupportedOperationException because List.of creates an immutable list, we cannot add or remove elements from it.


        //Array list
        System.out.println("\n----ArrayList Demonstration----");
        ArrayList list = new ArrayList();
        list.add("Hello");
        list.add(42);
        list.add(3.14);
        System.out.println("ArrayList: "+list);
        System.out.println("Size: "+list.size());
        System.out.println("Element at index 1: "+list.get(1));
        list.remove(1);
        System.out.println("After removing index 1: "+list);
        //array list is more dynamic than array, we can add and remove elements without worrying about size,
        // but it is less efficient than array for primitive types due to autoboxing and unboxing.

        List<Integer> intList = new ArrayList<>(List.of(1,2,3,4,5,1));
        System.out.println(intList);
        System.out.println(intList.isEmpty());
        System.out.println(intList.get(1));
        System.out.println(intList.contains(5));
        System.out.println(intList.indexOf(3));
        System.out.println(intList.lastIndexOf(1));
        intList.remove(4);
        System.out.println(intList);

        //Linkedlist performs the same operations,
        // but linkedlist is more efficient for adding and removing elements in the middle of the list,
        // but less efficient for accessing elements by index compared to arraylist also linkedlist mains insertion order while arraylist does not guarantee it.

        //more methods on arraylist

        intList.add(0,6);
        System.out.println(intList);
        intList.add(10);
        System.out.println(intList);
        intList.set(0,7);
        System.out.println(intList);
        Iterator numbers = intList.iterator();
        while(numbers.hasNext()){
            System.out.println(numbers.next());
        }


        //Set
        System.out.println("\n----Set Demonstration----");
        Set<String> city = new HashSet<>(List.of("New York", "Los Angeles", "Chicago", "New York"));
        System.out.println("Set: "+city);
        System.out.println("Size: "+city.size());
        System.out.println("Contains 'Chicago': "+city.contains("Chicago"));
        city.add("Houston");
        System.out.println("After adding 'Houston': "+city);
        city.remove("Los Angeles");
        System.out.println("After removing 'Los Angeles': "+city);
        //Set does not maintain insertion order and does not allow duplicate elements, it is more efficient

        //more methods on set
        TreeSet<Integer> nums = new TreeSet<>(Set.of(12,45,89,24,64,48,10));
        System.out.println(nums.floor(48));
        System.out.println(nums.lower(48));
        System.out.println(nums.ceiling(24));
        System.out.println(nums.higher(24));// returns the greatest element in this set less than or equal to the given element, or null if there is no such element.

    }
}
