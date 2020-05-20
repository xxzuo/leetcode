package lcof;

import problem_1_500.two_sum;

/**
 * xxzuo
 * 面试题03:数组中重复的数字
 * 2020/5/20
 */


public class FindRepeatNumber {

    public int findRepeatNumber(int[] nums) {
        int[] res = new int[100001];
        int ans = -1;
        for(int i = 0;i < nums.length;i++){
            if(res[nums[i]] > 0){
                ans = nums[i];
                break;
            }
            res[nums[i]]++;
        }
        return ans;
    }

}
