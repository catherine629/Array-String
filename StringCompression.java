// CC150 1.6
// Implement a method to perform basic string compression using the counts of repeated characters.
// For example, the string aabcccccaaa would become a2b1c5a3.
// If the compressed string would not become smaller that the original string, your method should return the original string.
// You can assume the string has only uppercase and lowercase letters (a-z).

class StringCompression {
	public static void main(String[] args) {
		String[] tests = {"abcdefg", "aaaabbccccee", "sasasasasa", "abbbbbbbceeeec"};
		for (String s: tests) {
			System.out.println(s + " " + compressString(s));
		}
	}
	
	private static String compressString(String s) {
		StringBuilder sb = new StringBuilder();
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			if (i == 0 || s.charAt(i) != s.charAt(i - 1)) {
				if (i != 0) {
					sb.append(count);
				}
				count = 1;
				sb.append(s.charAt(i));
			} else {
				count++;
			}
		}
		sb.append(count);
		return s.length() > sb.length()? sb.toString() : s;
	}
}