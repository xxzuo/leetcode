//给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。 
//
// 示例 1： 
//
// 输入: "babad"
//输出: "bab"
//注意: "aba" 也是一个有效答案。
// 
//
// 示例 2： 
//
// 输入: "cbbd"
//输出: "bb"
// 
// Related Topics 字符串 动态规划 
// 👍 2496 👎 0


package problem_1_500;
//Java：最长回文子串
public class P5LongestPalindromicSubstring{
    public static void main(String[] args) {
        Solution solution = new P5LongestPalindromicSubstring().new Solution();
        // TO TEST
        System.out.println(solution.longestPalindrome("babad"));

    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestPalindrome(String s) {
        int len = s.length();
        if(len < 2){
            return s;
        }
        int begin = 0;
        int maxLen = 1;
        char[] charArr = s.toCharArray();
        for(int i = 0 ;i < len - 1; i ++){
            for(int j = i + 1; j < len; j++){
                if(j - i + 1 > maxLen && vaildPalindrome(charArr,i,j)){
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }

        return s.substring(begin, begin + maxLen);
    }

    private boolean vaildPalindrome(char[] arr, int begin, int end){
        while(begin < end){
            if(arr[begin] != arr[end]){
                return false;
            }
            begin++;
            end--;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}