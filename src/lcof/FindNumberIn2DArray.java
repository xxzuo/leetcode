package lcof;

/**
 *在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/**
 * xxzuo
 * 面试题04. 二维数组中的查找
 * 2020/5/23
 */
public class FindNumberIn2DArray {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if(matrix.length == 0){
            return false;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int x = 0;
        int y = col - 1;
        boolean flag = false;
        //利用矩阵特性，从左上角开始
        //如果等于目标值，直接返回坐标
        //如果大于目标值，则向左移动
        //如果小于目标值，则向右移动
        while(x < row && y >= 0){
            if(matrix[x][y] == target){
                return true;
            }else if(matrix[x][y] < target){
                x++;
            }else if(matrix[x][y] > target){
                y--;
            }
        }
        return flag;
    }
}
