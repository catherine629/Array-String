public class ValidWordAbbr {

    HashMap<String, HashSet<String>> map = new HashMap();

    public ValidWordAbbr(String[] dictionary) {
        for (String s: dictionary) {
            String abbr = s.length() > 0 ? s.substring(0, 1) + (s.length() - 2) + s.substring(s.length() - 1, s.length()) : "-1";
            if (map.containsKey(abbr)) {
                map.get(abbr).add(s);
            } else {
                HashSet<String> set = new HashSet();
                set.add(s);
                map.put(abbr, set);
            }
        }
    }

    public boolean isUnique(String word) {
        String abbr = word.length() > 0 ? word.substring(0, 1) + (word.length() - 2) + word.substring(word.length() - 1, word.length()) : "-1";
        if (!map.containsKey(abbr)) {
            return true;
        } else {
            if (map.get(abbr).size() == 1 && map.get(abbr).contains(word)) {
                return true;
            } else {
                return false;
            }
        }
    }
}


// Your ValidWordAbbr object will be instantiated and called as such:
// ValidWordAbbr vwa = new ValidWordAbbr(dictionary);
// vwa.isUnique("Word");
// vwa.isUnique("anotherWord");
