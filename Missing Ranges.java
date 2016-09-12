public class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> results = new ArrayList<String>();
        if (nums == null) {
            return results;
        }
        int start = lower - 1;
        int end;
        for (int i = 0; i <= nums.length; i++) {
            end = i == nums.length? upper + 1 : nums[i];
            if (end == start + 2) {
                results.add("" + (start + 1));
            }  
            if (end > start + 2) {
                results.add((start + 1) + "->" + (end - 1));
            }
            start = end;
        }
        return results;
    }
}
