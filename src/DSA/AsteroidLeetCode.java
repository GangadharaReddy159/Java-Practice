package DSA;

import java.util.Arrays;
import java.util.Stack;

public class AsteroidLeetCode {
    //given an array [4,7,1,1,2,-3,-7,17]
    //elements of array are asteroid weights, positive means moving right, negative means moving left.
    //if asteroid moving right is greater than left moving asteroid left will be cancelled.
    //if asteroid moving left is greater than right moving asteroid right will be cancelled.
    //if both are same both will be cancelled.
    //return a array of integers which remains at the end.
    public static void main(String[] args) {
        int[] asteroids = {4,7,1,1,2,-3,-7,17};
        int[] result = asteroidCollision(asteroids);
        System.out.println(Arrays.toString(result));

    }

    private static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> order = new Stack<>();
        for(int asteroid:asteroids){
            boolean destroyed = false;
            while(!order.isEmpty() && asteroid<0 && order.peek()>0){
                int diff = asteroid+order.peek();
                if(diff<0){
                    order.pop();
                }
                else if(diff==0){
                    order.pop();
                    destroyed=true;
                    break;
                }
                else{
                    destroyed=true;
                    break;
                }
            }
            if(!destroyed){
                order.push(asteroid);
            }
        }
        return order.stream().mapToInt(i->i).toArray();
    }
}
