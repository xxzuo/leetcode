//给定两个数组，编写一个函数来计算它们的交集。 
//
// 
//
// 示例 1： 
//
// 输入：nums1 = [1,2,2,1], nums2 = [2,2]
//输出：[2]
// 
//
// 示例 2： 
//
// 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//输出：[9,4] 
//
// 
//
// 说明： 
//
// 
// 输出结果中的每个元素一定是唯一的。 
// 我们可以不考虑输出结果的顺序。 
// 
// Related Topics 排序 哈希表 双指针 二分查找


package problem_1_500;

import java.util.HashSet;
import java.util.Set;

//Java：两个数组的交集
public class P349IntersectionOfTwoArrays{
    public static void main(String[] args) {
        Solution solution = new P349IntersectionOfTwoArrays().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> temp = new HashSet<>();
        Set<Integer> resSet = new HashSet<>();
        int firstLen = nums1.length;
        int secondLen = nums2.length;
        for(int i = 0; i < firstLen; i++){
            temp.add(nums1[i]);
        }
        for(int j = 0; j < secondLen; j++){
            if(temp.contains(nums2[j])){
                resSet.add(nums2[j]);
            }
        }
        return resSet.stream().mapToInt(Number::intValue).toArray();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}