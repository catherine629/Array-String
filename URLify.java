class URLify {
	public static void main(String[] args) {
		String test = "Mr John Smith          ";
		System.out.println(urlify(test.toCharArray(), 13));
	}
	
	private static String urlify(char[] input, int len) {
		int totalLen = len;
		for (int i = 0; i < len; i++) {
			if (input[i] == ' ')
				totalLen += 2;
		}
		int i = totalLen - 1;
		int j = len - 1;
		while (j >= 0) {
			if (input[j] != ' ') {
				input[i--] = input[j--];
			} else {
				input[i] = '0';
				input[--i] = '2';
				input[--i] = '%';
				i--;
				j--;
			}
		}
		return new String(input);
	}
}