 /**
  * First question in http://www.1point3acres.com/bbs/thread-215128-1-1.html
  * @author yang
  */
  
public CheckTriangles {
    public int checkTriangles(int[] nums) {
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
            int j = i + 1, k = nums.length - 1;
            while (j < k) {
                if (nums[i] + nums[j] <= nums[k]) {
                    k--;
                } else {
                    generateTriangles(nums, i, j, k, results);
                }
                j++;
                while (j < nums.length - 1 && nums[j] == nums[j - 1]) j++;
                k = nums.length - 1;
            }
            i++;
            while (i < nums.length - 2 && nums[i] == nums[i - 1]) i++;
        }
        return results;
    }
 
    private void generateTriangles(int[] nums, int i, int j, int k, List<List<Integer>> results) {
        while (j < k) {
            results.add(Arrays.asList(nums[i], nums[j], nums[k]));
            k--;
            while (k > j && nums[k] == nums[k + 1]) k--;
        }
    }
}
