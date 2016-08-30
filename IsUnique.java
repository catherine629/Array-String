// CC150 1.1
// Implement an algorithm to determine if a string has all unique characters. What if you cannot use additional data structures?

import java.util.HashSet;
class IsUnique {
	public static void main(String[] args) {
		String[] s = {"abceee", "Aelsid", "", "    a", "32eil3s"};
		for (String ss: s) {
			System.out.println(ss + " " + isUniqueArr(ss));
			System.out.println(ss + " " + isUniqueHashSet(ss));
		}
	}
	
	private static boolean isUniqueArr(String s) {
		boolean[] letters = new boolean[128];
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (letters[c]) {
				return false;
			}
			letters[c] = true;
		}
		return true;
	}
	
	private static boolean isUniqueHashSet(String s) {
		HashSet<Character> charSet = new HashSet<Character>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (charSet.contains(c)) {
				return false;
			} else {
				charSet.add(c);
			}
		}
		return true;
	}
}
