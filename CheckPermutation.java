// CC150 1.2
// Given two strings, write a method to decide if one is a permutation of the other.

import java.util.Arrays;
import java.util.HashMap;

class CheckPermutation {
	public static void main(String[] args) {
		String[][] tests = {{"abc", "dwd"}, {"eio", "ieo"}, {"   ", "e"}, {"ejwoij", "jjiowe"}};
		for (String[] ss: tests) {
			System.out.println(ss[0] + " " + ss[1] + " " + toSort(ss[0], ss[1]) + " " + toHashMap(ss[0], ss[1]));
		}
	}
	
	public static boolean toSort(String s1, String s2) {
		int l1 = s1.length();
		int l2 = s2.length();
		if (l1 != l2) {
			return false;
		}
		char[] c1 = s1.toCharArray();
		char[] c2 = s2.toCharArray();
		Arrays.sort(c1);
		Arrays.sort(c2);
		for (int i = 0; i < l1; i++) {
			if (c1[i] != c2[i]) {
				return false;
			} 
		}
		return true;
	}
	
	public static boolean toHashMap(String s1, String s2) {
		if (s1.length() != s2.length())
			return false;
		HashMap<Character, Integer> countMap = new HashMap<Character, Integer>();
		for (int i = 0; i < s1.length(); i++) {
			if (!countMap.containsKey(s1.charAt(i))) {
				countMap.put(s1.charAt(i), 1);
			} else {
				countMap.put(s1.charAt(i), countMap.get(s1.charAt(i)) + 1);
			}
		}
		for (int i = 0; i < s2.length(); i++) {
			if (!countMap.containsKey(s2.charAt(i))) {
				return false;

			} else {
				if (countMap.get(s2.charAt(i)) - 1 < 0) {
					return false;
				}
				countMap.put(s2.charAt(i), s2.charAt(i)  - 1);
			}
		}
		return true;
	}
}
