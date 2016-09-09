/**
 * public class NBCompare {
 *     public int cmp(String a, String b);
 * }
 * You can use compare.cmp(a, b) to compare nuts "a" and bolts "b",
 * if "a" is bigger than "b", it will return 1, else if they are equal,
 * it will return 0, else if "a" is smaller than "b", it will return -1.
 * When "a" is not a nut or "b" is not a bolt, it will return 2, which is not valid.
*/
/*
Idea: Use nut as a pivot to quicksort bolts, and use the corresponding bolt pivot to quicksort nut, until the two arrays are sorted
*/
public class Solution {
    /**
     * @param nuts: an array of integers
     * @param bolts: an array of integers
     * @param compare: a instance of Comparator
     * @return: nothing
     */
    public void sortNutsAndBolts(String[] nuts, String[] bolts, NBComparator compare) {
        // write your code here
        if (nuts == null || bolts == null || nuts.length != bolts.length) {
            return;
        }
        quickSort(nuts, bolts, compare, 0, nuts.length - 1);
    }
    private void quickSort(String[] nuts, String[] bolts, NBComparator compare, int start, int end) {
        if (start >= end) {
            return;
        }
        int boltIndex = partition(nuts[start], bolts, compare, start, end);
        partition(bolts[boltIndex], nuts, compare, start, end);
        quickSort(nuts, bolts, compare, start, boltIndex - 1);
        quickSort(nuts, bolts, compare, boltIndex + 1, end);
        
    }
    private int partition(String pivot, String[] str, NBComparator compare, int l, int r) {
        for (int i = l; i <= r; i++) {
            if (compare.cmp(pivot, str[i]) == 0 || compare.cmp(str[i], pivot) == 0) {
                swap(str, i, l);
                break;
            }
        }
        int left = l, right = r;
        String tmp = str[l];
        while (left < right) {
            while (left < right && (compare.cmp(pivot, str[right]) == -1 ||
            compare.cmp(str[right], pivot) == 1)) {
                right--;
            }
            str[left] = str[right];
            while (left < right && (compare.cmp(pivot, str[left]) == 1 ||
            compare.cmp(str[left], pivot) == -1)) {
                left++;
            }
            str[right] = str[left];
        }
        str[left] = tmp;
        return left;
    }
    private void swap(String[] str, int idx1, int idx2) {
        String tmp = str[idx1];
        str[idx1] = str[idx2];
        str[idx2] = tmp;
    }
   
};
