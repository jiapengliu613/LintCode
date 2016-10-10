class Solution {
    /**
     * @param S: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> S) {
        // write your code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (S == null || S.size() == 0) {
            return result;
        }
        Collections.sort(S);
        ArrayList<Integer> list = new ArrayList<>();
        helper(result, S, list, 0);
        return result;
    }
    
    public void helper(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> S,
                       ArrayList<Integer> list, int pos) {
        result.add(new ArrayList<Integer>(list));
        for (int i = pos; i < S.size(); i++) {
            if (i != pos && S.get(i) == S.get(i - 1)) {
                continue;
            }
            list.add(S.get(i));
            helper(result, S, list, i + 1);
            list.remove(list.size() - 1);
        }
    }
}

class Solution {
    /**
     * @param S: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> S) {
        // write your code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (S == null || S.size() == 0) {
            return result;
        }
        Collections.sort(S);
        HashSet<ArrayList<Integer>> set = new HashSet<>();
        ArrayList<Integer> cur = new ArrayList<>();
        helper(S, result, cur, 0, set);
        return result;
    }
    private void helper(ArrayList<Integer> S, ArrayList<ArrayList<Integer>> result,
                        ArrayList<Integer> cur, int pos, HashSet<ArrayList<Integer>> set) {
        if (pos == S.size()) {
            if (result.size() == 0 || !set.contains(cur)) {
                ArrayList<Integer> tmp = new ArrayList<>(cur);
                result.add(tmp);
                set.add(tmp);
            }
            return ;
        }     
        
        cur.add(S.get(pos));
        helper(S, result, cur, pos + 1, set);
        cur.remove(cur.size() - 1);
        
        helper(S, result, cur, pos + 1, set);
    }
    
}

