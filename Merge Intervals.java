/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> results = new ArrayList<Interval>();
        if (intervals.size() == 0) {
            return results;
        }
        // sort the intervals
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval i1, Interval i2) {
                if (i1.start != i2.start) {
                    return i1.start - i2.start;
                } else {
                    return i1.end - i2.end;
                }
            }
        });
        // combine intervals
        Interval curr = intervals.get(0);
        for (int i = 1; i < intervals.size(); i++) {
            Interval toCom = intervals.get(i);
            if (curr.end < toCom.start) {
                // current interval doesn't intersect with the next one
                results.add(curr);
                curr = toCom;
            } else {
                // current interval intersects with the next one
                curr = new Interval(Math.min(curr.start, toCom.start), Math.max(curr.end, toCom.end));
            }
        }
        results.add(curr);
        return results;
    }
}
