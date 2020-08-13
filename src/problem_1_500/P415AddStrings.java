//给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。 
//
// 注意： 
//
// 
// num1 和num2 的长度都小于 5100. 
// num1 和num2 都只包含数字 0-9. 
// num1 和num2 都不包含任何前导零。 
// 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式。 
// 
// Related Topics 字符串 
// 👍 197 👎 0


package problem_1_500;
//Java：字符串相加
public class P415AddStrings{
    public static void main(String[] args) {
        Solution solution = new P415AddStrings().new Solution();
        // TO TEST

        String s1 = "584";
        String s2 = "18";
        System.out.println(solution.addStrings(s1,s2));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String addStrings(String num1, String num2) {
        int first = num1.length();
        int second = num2.length();
        int min = Math.min(first,second);
        StringBuilder sb = new StringBuilder();
        boolean flag = false;
        for(int i = 0;i < min; i++){
            int c1 = num1.charAt(first - 1 - i) - '0';
            int c2 = num2.charAt(second - 1 - i) - '0';
            int temp = c1 + c2;
            if(flag){
                temp += 1;
                flag = false;
            }
            if(c1 + c2 >= 10){
                flag = true;
                temp = temp - 10;
            }
            sb.insert(0,temp);
        }

        if(first == second && flag){
            sb.insert(0,1);
            flag = false;
        }
        if(first != second){
            if(first > second){
                for(int j = second; j < first; j++){
                    int addNum = num1.charAt(first - 1 - j) - '0';
                    if(flag){
                        addNum += 1;
                        flag = false;
                    }
                    if(addNum >= 10){
                        addNum  = addNum - 10;
                        flag = true;
                    }
                    sb.insert(0,addNum);
                }
            }else if(second > first){
                for(int j = first; j < second; j++){
                    int addNum = num2.charAt(second - 1 - j) - '0';
                    if(flag){
                        addNum += 1;
                        flag = false;
                    }
                    if(addNum >= 10){
                        addNum  = addNum - 10;
                        flag = true;
                    }
                    sb.insert(0,addNum);
                }
            }
        }
        if(flag){
            sb.insert(0,1);
            flag = false;
        }
        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}