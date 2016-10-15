public class Solution {
    /**
     * @param s the IP string
     * @return All possible valid IP addresses
     */
    public ArrayList<String> restoreIpAddresses(String s) {
        // Write your code here
        ArrayList<String> result = new ArrayList<>();
        if (s == null || s.length() == 0 || s.length() < 4 || s.length() > 12) {
            return result;
        } 
        ArrayList<String> curList = new ArrayList<>();
        helper(s, result, curList, 0);
        return result; 
    }
    private void helper(String s, ArrayList<String> result, ArrayList<String> curList, int index) {
        if (curList.size() == 4) {
            if (index < s.length()) {
                return ;
            }
            StringBuilder sb = new StringBuilder();
            for(String tmp: curList) {
                sb.append(tmp);
                sb.append(".");
            }
            sb.deleteCharAt(sb.length()-1);
            result.add(sb.toString()); 
            return ;
        }
        if (index == s.length()) {
            return ;
        }
        for (int i = index; i < s.length() && i < 3 + index; i++) {
            String tmp = s.substring(index, i + 1);
            if (isValid(tmp)) {
                curList.add(tmp);
                helper(s, result, curList, i + 1);
                curList.remove(curList.size() - 1);
            }
        
        }
    }
    private boolean isValid(String s) {
        if (s.charAt(0) == '0') {
            return s.equals("0");
        }
        int digit = Integer.valueOf(s);
        return digit >= 0 && digit <= 255;
    }
}