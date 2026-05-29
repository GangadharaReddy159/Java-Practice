class Solution {
    public int romanToInt(String s) {
        int total =0;
        int length = s.length();

        for(int i=0;i<length;i++){
            int currentValue = getValue(s.charAt(i));

            //checking if the next character is greater or lesser
            if(i<length-1 && currentValue< getValue(s.charAt(i+1))){
                total-=currentValue;
            }
            else{
                total+=currentValue;
            }
        }
        return total;

    }


    private int getValue(char c){
        switch(c){
            case 'I':return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }
}

class Leetcode {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "MCMXCIV";
        int result = solution.romanToInt(s);
        System.out.println(result); // Output: 1994
    }
}