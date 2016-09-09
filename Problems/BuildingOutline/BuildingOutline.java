class Height {
    int start;
    int height;
    public Height(int start, int height) {
        this.start = start;
        this.height = height;
    }
    public static Comparator<Height> mycmp = new Comparator<Height>()
    {
        public int compare(Height h1, Height h2) {
            if (h1.start == h2.start) {
                return h1.height - h2.height;
            }
            return h1.start - h2.start;
        }
    };
}
public class Solution {
    /**
     * @param buildings: A list of lists of integers
     * @return: Find the outline of those buildings
     */
    public ArrayList<ArrayList<Integer>> buildingOutline(int[][] buildings) {
        // write your code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (buildings == null || buildings.length == 0 || buildings[0].length == 0) {
            return result;
        }
        ArrayList<Height> heights = new ArrayList<>();
        for (int[] building : buildings) {
            heights.add(new Height(building[0], -building[2]));
            heights.add(new Height(building[1], building[2]));
        }
        Collections.sort(heights, Height.mycmp);
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(1000, Collections.reverseOrder());
        pq.offer(0);
        int prev = 0;
        for (int i = 0; i < heights.size(); i++) {
            if (heights.get(i).height < 0) {
                pq.offer(-heights.get(i).height);
            } else {
                pq.remove(heights.get(i).height);
            }
            int current = pq.peek();
            
            if (current != prev) {
                ArrayList<Integer> tmp = new ArrayList<>();
                tmp.add(heights.get(i).start);
                tmp.add(current);
                result.add(tmp);
                prev = current;
            }
        }
        return output(result);
        
    }
    //Convert output
    private ArrayList<ArrayList<Integer>> output(ArrayList<ArrayList<Integer>> input) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for (int i = 0; i < input.size() - 1; i++) {
            if (input.get(i).get(1) > 0) {
                ArrayList<Integer> tmp = new ArrayList<>();
                tmp.add(input.get(i).get(0));
                tmp.add(input.get(i + 1).get(0));
                tmp.add(input.get(i).get(1));
                result.add(tmp);
            }
        }
        return result;
    }
}
