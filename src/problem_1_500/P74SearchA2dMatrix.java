//编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性： 
//
// 
// 每行中的整数从左到右按升序排列。 
// 每行的第一个整数大于前一行的最后一个整数。 
// 
//
// 示例 1: 
//
// 输入:
//matrix = [
//  [1,   3,  5,  7],
//  [10, 11, 16, 20],
//  [23, 30, 34, 50]
//]
//target = 3
//输出: true
// 
//
// 示例 2: 
//
// 输入:
//matrix = [
//  [1,   3,  5,  7],
//  [10, 11, 16, 20],
//  [23, 30, 34, 50]
//]
//target = 13
//输出: false 
// Related Topics 数组 二分查找 
// 👍 214 👎 0


package problem_1_500;
//Java：搜索二维矩阵
public class P74SearchA2dMatrix{
    public static void main(String[] args) {
        Solution solution = new P74SearchA2dMatrix().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        if(row == 0){
            return false;
        }
        int col = matrix[0].length;
        if(col == 0){
            return false;
        }
        int rowLeft = 0;
        int rowRight = row - 1;
        if(target > matrix[row - 1][col - 1] || target < matrix[0][0]){
            return false;
        }
        while(rowLeft < rowRight){
            int rowMid = rowLeft + (rowRight - rowLeft) / 2;
            if(target < matrix[rowMid][0] ){
                rowRight = rowMid - 1;
            }else if(target > matrix[rowMid][col - 1]){
                rowLeft = rowMid + 1;
            }else{
                rowLeft = rowMid;
                break;
            }
        }
        int colLeft = 0;
        int colRight = col - 1;
        while(colLeft < colRight){
            int colMid = colLeft + (colRight - colLeft) / 2;
            if(target < matrix[rowLeft][colMid]){
                colRight = colMid;
            }else if(target > matrix[rowLeft][colMid]){
                colLeft = colMid + 1;
            }else{
                return true;
            }
        }
        if(target == matrix[rowLeft][colLeft]){
            return true;
        }else if(target == matrix[rowLeft][colRight]){
            return true;
        }else{
            return false;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}