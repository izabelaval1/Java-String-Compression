//The goal is to create a method that compress a string by reducing sequences of
// repeating characters into the character followed by the number of times it repeats consecutively.

//Task: In your own words, describe the key parts of your solution and the reasoning behind your approach.
// You can use comments in your code to explain your thought process.
//Input: The input string will contain only lowercase letters. It might be empty.Output :
//"aaabb" → "a3b2"
// "abc" → "a1b1c1"
// "" → ""
//Optionally: Add decompressing method, which reconstructs the original string.
//Input: string will contain characters followed by a number indicating how many times the character repeats consecutively.
//Output:
//"a3b2" → "aaabb"
//"a1b1c1" → "abc"
//"" → ""

public class Main {
    public static void main(String[] args) {

        System.out.println(compressString("aaabb"));
        System.out.println(compressString("abc"));
        System.out.println(compressString(""));

        System.out.println(decompressString("a3b2"));
        System.out.println(decompressString("a1b1c1"));
        System.out.println(decompressString(""));

    }

    public static String compressString(String input) {

        //if string is empty, return empty string
        if(input == null || input.isEmpty()) {
            return "";
        }

        String compressed = "";
        int count = 1;

        //iterating through the string, i+1 has to be the last index;
        for(int i = 0; i < input.length() - 1; i++) {

            //checking if our current character is the same as the next, and if so - incrementing the count until characters differ
            if(input.charAt(i) == input.charAt(i+1)) {
                count++;
            }
            else {
                // if characters not the same, we can add previous letters with its count to the compressed string
                compressed += input.charAt(i) + "" + count;
                count = 1; //reset count to the next letter

            }

        }
        //after the loop, append the last character and its count
        compressed += input.charAt(input.length() - 1) + "" + count;
        return compressed;
    }

    public static String decompressString(String input) {


        //if string is empty, return empty string
        if(input == null || input.isEmpty()) {
            return "";
        }

        String decompressed = "";

        int i = 0;

        //loop through the string and get the character
        while(i < input.length()) {
            char ch = input.charAt(i);

            i++; //move to the next character to get the count

            String count = ""; //string to store the count

            //count the number in case more than one digit and add the digit to the count string;
            while(i < input.length() && Character.isDigit(input.charAt(i))) {
                count += input.charAt(i);
                i++;
            }

            int countInt;

            //if no count, count is 1, else -> convert string to an integer
            if(count.isEmpty()) {
                countInt = 1;
            }
            else {
                countInt = Integer.parseInt(count);
            }

            //add the character to the result countInt times
            for(int j = 0; j < countInt; j++) {
                decompressed += ch;
            }
        }

        return decompressed;
    }

}