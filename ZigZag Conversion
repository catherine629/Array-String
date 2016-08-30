// LeetCode 6
// The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern 
// in a fixed font for better legibility)
// P   A   H   N
// A P L S I I G
// Y   I   R
// And then read line by line: "PAHNAPLSIIGYIR"
// Write the code that will take a string and make this conversion given a number of rows

public class Solution {
    public String convert(String s, int numRows) {
        if (numRows < 2)
            return s;
        char[] arr = new char[s.length()];
        int count = 0;
        for (int i = 0; i < numRows; i++) {
            if (i == 0 || i == numRows - 1) {
                int index = i;
                while (index < s.length() && count < s.length()) {
                    arr[count++] = s.charAt(index);
                    index += 2 * (numRows - 1);
                }
            } else {
                int index = i;
                while (index < s.length() && count < s.length()) {
                    arr[count++] = s.charAt(index);
                    index += numRows > i + 1? (numRows -i - 1) * 2 : 1;
                    if (index < s.length() && count < s.length()) {
                        arr[count++] = s.charAt(index);
                        index += i > 0? 2 * i : 1; 
                    }
                }
                
            } 
        }
        return new String(arr);
    }
}
