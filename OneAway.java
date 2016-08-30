// CC150 1.5
// There are three types of edits that can be performed on string: insert a character, remove a character, or replace a character.
// Given two string, write a function to check if they are one edit (or zero edits) away.

class OneAway {
	public static void main(String[] args) {
		String[][] test = {{"abc", "ab"}, {"pael", "bael"}, {"efjio", "fej"}, {"ejwe", "bjwb"}};
		for (String[] s: test) {
			System.out.println(s[0] + " " + s[1] + " " + oneAway(s[0], s[1]));
		}
	}
	
	private static boolean oneAway(String s1, String s2) {
		if (Math.abs(s1.length() - s2.length()) >= 2) {
			return false;
		}
		int index1 = 0;
		int index2 = 0;
		while (index1 < s1.length() && index2 < s2.length() && s1.charAt(index1) == s2.charAt(index2)) {
			index1++;
			index2++;
		}
		if (s1.length() > s2.length()) {
			index1++;
		} else if (s1.length() < s2.length()){
			index2++;
		} else {
			index1++;
			index2++;
		}
		while (index1 < s1.length() && index2 < s2.length()) {
			if (s1.charAt(index1) != s2.charAt(index2)) {
				return false;
			}
			index1++;
			index2++;
		}
		return true;
	}
}
