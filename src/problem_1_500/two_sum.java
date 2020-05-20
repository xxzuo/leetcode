package problem_1_500;

/**
 * xxzuo
 * leetcode_1
 * 2020/5/20
 */
public class two_sum {

    public static void main(String[] args) {
        Solution solution = new two_sum().new Solution();
    }


    class Solution {
        public int[] twoSum(int[] nums, int target) {
            if(nums == null || nums.length<=1){
                return null;
            }
            //暴力
            for (int i = 0; i < nums.length; i++) {
                for (int j = i+1; j < nums.length; j++) {
                    if (nums[i] + nums[j] == target){
                        return new int[] {i,j};
                    }
                }
            }
            throw new IllegalArgumentException("No two sum solution");
        }
    }
}
