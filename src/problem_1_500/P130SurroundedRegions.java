//给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。 
//
// 找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。 
//
// 示例: 
//
// X X X X
//X O O X
//X X O X
//X O X X
// 
//
// 运行你的函数后，矩阵变为： 
//
// X X X X
//X X X X
//X X X X
//X O X X
// 
//
// 解释: 
//
// 被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被
//填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。 
// Related Topics 深度优先搜索 广度优先搜索 并查集 
// 👍 310 👎 0


package problem_1_500;
//Java：被围绕的区域
public class P130SurroundedRegions{
    public static void main(String[] args) {
        Solution solution = new P130SurroundedRegions().new Solution();
        // TO TEST
        char[][] testCase = new char[][]{
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}
        };
        solution.solve(testCase);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        private int row;
        private int col;
    public void solve(char[][] board) {
        int min = Integer.MAX_VALUE;
        row = board.length;
        if(row == 0){
            return;
        }
        col = board[0].length;
        if(col == 0){
            return;
        }
        //用于记录从边界访问的节点
        boolean[][] visited = new boolean[row][col];
        //搜索上下边界
        for(int j = 0; j < col; j++){
            if(board[0][j] == 'O'){
                dfs(board, visited, 0, j);
            }
            if(board[row - 1][j] == 'O'){
                dfs(board, visited, row - 1, j);
            }
        }
        //搜索左右边界
        for(int i = 0; i < row; i++){
            if(board[i][0] == 'O'){
                dfs(board, visited, i, 0);
            }
            if(board[i][col - 1] == 'O'){
                dfs(board, visited, i, col - 1);
            }
        }

        for(int n = 0; n < row; n++){
            for(int m = 0; m < col; m++){
                if(board[n][m] == 'O' && !visited[n][m]){
                    board[n][m] = 'X';
                }
            }
        }

    }

    private void dfs(char[][] board, boolean[][] visited, int i, int j){
        if(i < 0 || i >=row || j < 0 || j >= col){
            return;
        }
        if(board[i][j] == 'X' || visited[i][j]){
            return;
        }
        visited[i][j] = true;
        dfs(board, visited, i + 1, j);
        dfs(board, visited, i - 1, j);
        dfs(board, visited, i, j + 1);
        dfs(board, visited, i, j - 1);

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}