import java.util.Locale;

public class Challenges {
    /** Create a function which returns the number of true values there are in an array.*/
    public static int countTrueFalse(boolean[] arr) {
        int output = 0;
        for (boolean trueOrFalse : arr) {
            if (trueOrFalse) output++;
        }
        return output;
    }

    /** Create a function that takes an array and returns the absolute difference between the biggest and smallest numbers.*/
    public static int differenceMinMax(int[] nums){
        int biggest = nums[1], smallest = nums[1];
        for (int value : nums) {
            if (value > biggest) biggest = value;
            if (value < smallest) smallest = value;
        }
        return biggest-smallest;
    }

    /**
     * Stutter
     * Write a function that stutters a word as if someone is struggling to read it.
     * The first two letters are repeated twice with an ellipsis ... and space after each,
     * and then the word is pronounced with a question mark ?
     */
    public static String stutter(String str){
        return str.substring(0,2)+"... "+str.substring(0,2)+"... "+str+"?";
    }

    /** Write a function that takes an array of numbers and returns the second largest number.*/
    public static int secondLargestNumber(int[] nums){
        int largest = nums[0], secondLargest = nums[0];
        for (int value : nums) {
            if (value > largest) {
                largest = value;
            }
        }
        if (secondLargest == largest) secondLargest = nums[1];
        for (int value : nums) {
            if (value > secondLargest && value < largest) {
                secondLargest = value;
            }
        }
        return secondLargest;
    }

    /**
     FizzBuzz
     Create a function that takes a number as an argument and returns "Fizz", "Buzz" or "FizzBuzz".
     If the number is a multiple of 3 the output should be "Fizz".
     If the number given is a multiple of 5, the output should be "Buzz".
     If the number given is a multiple of both 3 and 5, the output should be "FizzBuzz".
     If the number is not a multiple of either 3 or 5, the number should be output on its own as shown in the examples below.
     The output should always be a string even if it is not a multiple of 3 or 5.
     **/
    public static String fizzBuzz(int num){
        if (num%3 == 0 && num%5 == 0) return "FizzBuzz";
        if (num%3 == 0) return "Fizz";
        if (num%5 == 0) return "Buzz";
        return num+"";
    }

    /**
     * Skip Counting
     * Write a program that gets three integers from the user.
     * Count from the first number to the second number in increments of the third number.
     */
    public static String skipCount(int countFrom, int countTo, int countBy){
        if (countFrom > countTo) {
            return "Try again with better numbers!";
        }
        String output = "";
        int currentCount = countFrom;
        while (currentCount <= countTo) {
            output = output + currentCount+".. ";
            currentCount += countBy;
        }
        return output.substring(0,output.length()-3);
    }

    /** The "Reverser"
     * takes a string as input and returns that string in reverse order, with the opposite case.*/
    public static String reverser(String reverseMe){
        char currentChar;
        String output = "";
        for (int i=0;i<reverseMe.length();i++) {
            currentChar = reverseMe.charAt(reverseMe.length()-i-1);
            if (Character.getType(currentChar) == Character.UPPERCASE_LETTER) {
                currentChar = Character.toLowerCase(currentChar);
            } else {
                currentChar = Character.toUpperCase(currentChar);
            }
            output = output + currentChar;
        }
        return output;
    }

    /**
     * Reverse An Array
     * Write a function that reverses the order of an array
     */
    public static int[] reverseArray(int[] arr){
        int output[] = new int[arr.length];
        if (arr.length == 0) {
            return output;
        }
        for (int i=0;i<arr.length;i++) {
            output[i] = arr[arr.length-i-1];
        }
        return output;
    }

    /**
     * Write a function that finds the word "bomb" in the given string (not case sensitive).
     * Return "DUCK!" if found, otherwise,"Relax, there's no bomb.".
     */
    public static String duckTheBomb(String checkMe){
        checkMe = checkMe.toLowerCase(Locale.ROOT);
        for (int i=0;i<checkMe.length()-4;i++) {
            if (checkMe.substring(i,i+4).equals("bomb")) return "DUCK!";
        }
        return "Relax, there's no bomb.";
    }

    /** Sort in Ascending Order
     * Create a method that takes an array of integers and returns a new array, sorted in ascending order (smallest to biggest).
     * If the function's argument is null, an empty array or undefined, return an empty array
     */
    public static int[] sortNumsAscending(int[] nums){
        if (nums.length == 0) return new int [0];
        if (nums.length == 1) return nums;
        int[] output = new int[nums.length];
        int cutoff = 0, largest = nums[0], duplicates = 0;
        for (int value : nums) {
            if (value > largest) largest = value; //finds largest number in array
        }
        int smallest = largest;
        for (int i=0; i<nums.length; i++) {
            if (duplicates==0) {
                smallest = largest;
                for (int j=0; j<nums.length; j++) {
                    if (i>0) {
                        if (nums[j] <= smallest && nums[j] > cutoff) { //finds smallest number in array that is above the cutoff
                            smallest = nums[j];
                        }
                    } else {
                        if (nums[j] < smallest) {
                            smallest = nums[j];
                        }
                    }
                }
                for (int j=0;j<nums.length;j++) {
                    if (nums[j] == smallest && smallest < largest) {
                        duplicates++;
                    }
                }
            }
            output[i] = smallest;
            cutoff = smallest; //sets the cutoff to the smallest number before running again
            if (duplicates > 0) duplicates--;
        }
        return output;
    }

    /**
     * Remove Duplicates
     * Create a method that takes an array of strings,removes all duplicate items
     * and returns a new array in the same sequential order as the old array (minus duplicates).
     */
    public static String[] removeDups(String[] str){
        String[] arrayToCopy = new String[str.length];
        int idx = 0, shrink = 0;
        boolean isDuplicate;
        for (String item : str) {
            isDuplicate = false;
            for (int i=0;i<idx+1;i++) {
                if (item.equals(arrayToCopy[i])) {
                    isDuplicate = true;
                    shrink++;
                }
            }
            if (!isDuplicate) {
                arrayToCopy[idx] = item;
                idx++;
            }
        }
        String[] output = new String[arrayToCopy.length-shrink]; //copies arrayToCopy to a new array with the proper length
        for (int i=0;i<output.length;i++) {
            output[i] = arrayToCopy[i];
        }
        return output;
    }
}