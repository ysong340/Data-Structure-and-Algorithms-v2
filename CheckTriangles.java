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
}
