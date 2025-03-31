/*
// Definition for an Interval.
class Interval {
    public int start;
    public int end;

    public Interval() {}

    public Interval(int _start, int _end) {
        start = _start;
        end = _end;
    }
};
*/

class Solution {
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> intervals = new ArrayList<>();
        for(List<Interval> i: schedule){
            intervals.addAll(i);
        }
        Collections.sort(intervals, (a, b) -> a.start - b.start);
        List<Interval> merged = new ArrayList<>();
        for(Interval interval: intervals){
            if(merged.isEmpty() || merged.get(merged.size() - 1).end < interval.start){
                merged.add(interval);
            } else {
                merged.get(merged.size() - 1).end = Math.max(merged.get(merged.size() - 1).end, interval.end);
            }
        }
        List<Interval> ans = new ArrayList<>();
        for(int i = 0;i<merged.size()-1;i++){
            ans.add(new Interval(merged.get(i).end, merged.get(i+1).start));
        }
        return ans;
    }
}