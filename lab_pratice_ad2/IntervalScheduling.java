package lab_pratice_ad2;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Interval {
    int start;
    int end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

public class IntervalScheduling {

    public static List<Interval> schedule(List<Interval> intervals) {
        List<Interval> selectedIntervals = new ArrayList<>();
        
       
        Collections.sort(intervals, Comparator.comparingInt(i -> i.end));
        
     
        int currentEnd = Integer.MIN_VALUE;
        for (Interval interval : intervals) {
            if (interval.start >= currentEnd) {
                selectedIntervals.add(interval);
                currentEnd = interval.end;
            }
        }
        
        return selectedIntervals;
    }

    public static void main(String[] args) {
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1, 3));
        intervals.add(new Interval(2, 4));
        intervals.add(new Interval(3, 6));
        intervals.add(new Interval(5, 7));
        intervals.add(new Interval(8, 9));

        List<Interval> selectedIntervals = schedule(intervals);

        System.out.println("Selected Intervals:");
        for (Interval interval : selectedIntervals) {
            System.out.println("[" + interval.start + ", " + interval.end + "]");
        }
    }
}
