import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


class Point {
    int time;
    int flag;
    public Point(int time, int flag) {
        this.time = time;
        this.flag = flag;
    }
}
class Interval {
		 int start, end;
		 Interval(int start, int end) {
		 this.start = start;
		 this.end = end;
		 }
	}
public class Solution {

	/**
	 * @param args
	 */
	
	
   public int countOfAirplanes(List<Interval> airplanes) { 
       // write your code here
       /*
       if (airplanes == null || airplanes.size() == 0) {
           return 0;
       }
       HashMap<Integer, Integer> hashMap = new HashMap<>();
       int max = 0;
       for (Interval interval: airplanes) {
           for (int i = interval.start; i < interval.end; ++i) {
               if (hashMap.containsKey(i)) {
                   hashMap.put(i, hashMap.get(i) + 1);
               } else {
                   hashMap.put(i, 1);
               }
               max = Math.max(hashMap.get(i), max);
           }
       }
       return max;
       */
       if (airplanes == null || airplanes.size() == 0) {
           return 0;
       }
       ArrayList<Point> timeTable = new ArrayList<>();
       for (Interval interval : airplanes) {
           timeTable.add(new Point(interval.start, 1));
           timeTable.add(new Point(interval.end, 0));
       }
       Collections.sort(timeTable, (o1, o2) -> o1.time - o2.time);
       int max = 0;
       int count = 0;
       for (Point point : timeTable) {
           if (point.flag == 1) {
               count++;
           } else {
               count--;
           }
           max = Math.max(max, count);
       }
       return max;

   }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
                
                List<Interval> table = new ArrayList<>();
                table.add(new Interval(1, 10));
                table.add(new Interval(2, 3));
                table.add(new Interval(5, 8));
                table.add(new Interval(4, 7));
                Solution s = new Solution();
                System.out.print(s.countOfAirplanes(table));

	}

}
