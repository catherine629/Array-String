public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> results = new ArrayList<String>();
        if (nums == null || nums.length == 0) {
            return results;
        }
        int start = 0;
        int end;
        for (end = 1; end <= nums.length; end++) {
            if (end == nums.length || nums[end] > nums[end - 1] + 1) {
                if (start + 1 == end) {
                    results.add("" + nums[start]);
                } else {
                    results.add(nums[start] + "->" + nums[end - 1]);
                }
                start = end;
            }
        }
        return results;
    }
}
