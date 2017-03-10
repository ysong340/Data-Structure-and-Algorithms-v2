import java.util.*;
 /**
  * First question in http://www.1point3acres.com/bbs/thread-215128-1-1.html
  * @author yang
  */
public class Solution {
    public boolean checkTriangles(int[] nums) {
        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] + nums[i + 1] > nums[i + 2]) {
                return true;
            }
        }
        return false;
    }
 
    public List<List<Integer>> getAllTriangles(int[] nums) {
        Arrays.sort(nums);
     
        List<List<Integer>> results = new ArrayList<>();
        int i = 0;
        while (i < nums.length - 2) {
            int j = i + 1;
            while (j < nums.length - 1) {
                int k = j + 1;
                while (k < nums.length) {
                    if (nums[i] + nums[j] > nums[k]) {
                        results.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    }
                    k++;
                    while (k < nums.length && nums[k] == nums[k - 1]) k++;
                }
                j++;
                while (j < nums.length && nums[j] == nums[j - 1]) j++;
            }
            i++;
            while (i < nums.length - 2 && nums[i] == nums[i - 1]) i++;
        }
        return results;
    }

    public static void main(String[] args) {
        int[] nums = {10, 21, 22, 100, 101, 200, 300};
        Solution s = new Solution();
        System.out.println(s.getAllTriangles(nums));
    }
}
