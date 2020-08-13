//给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。 
//
// 你的算法时间复杂度必须是 O(log n) 级别。 
//
// 如果数组中不存在目标值，返回 [-1, -1]。 
//
// 示例 1: 
//
// 输入: nums = [5,7,7,8,8,10], target = 8
//输出: [3,4] 
//
// 示例 2: 
//
// 输入: nums = [5,7,7,8,8,10], target = 6
//输出: [-1,-1] 
// Related Topics 数组 二分查找 
// 👍 522 👎 0


package problem_1_500;
//Java：在排序数组中查找元素的第一个和最后一个位置
public class P34FindFirstAndLastPositionOfElementInSortedArray{
    public static void main(String[] args) {
        Solution solution = new P34FindFirstAndLastPositionOfElementInSortedArray().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 0){
            return new int[]{-1,-1};
        }
        if(nums.length == 1){
            if(target == nums[0]){
                return new int[]{0,0};
            }
        }
        if(target == nums[0] && target == nums[nums.length - 1]){
            return new int[]{0,nums.length - 1};
        }
        int left = 0;
        int right = nums.length - 1;
        int[] res = new int[2];
        //分别搜索左右边界
        //搜索左边界
        while(left < right){
            int mid = left + (right - left) / 2;
            if(target < nums[mid]){
                right = mid;
            }else if(target > nums[mid]){
                left = mid + 1;
            }else if(target == nums[mid]){
                right = mid;
            }
        }
        if(target != nums[left]){
            return new int[]{-1,-1};
        }
        res[0] = left;
        //搜索右边界
        left = 0;
        right = nums.length;
        while(left < right){
            int mid = left + (right - left) / 2;
            if(target < nums[mid]){
                right = mid;
            }else if(target > nums[mid]){
                left = mid + 1;
            }else if(target == nums[mid]){
                left = mid + 1;
            }
        }
        res[1] = left - 1;

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}