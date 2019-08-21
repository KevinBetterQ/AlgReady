package practice;

/*
 * 关键时定义好 find 这个递归函数
 * 不需要改变原二维数组结构的，直接 传值 + 坐标 ，按照坐标来判断结束条件。
 */

public class 单词搜索 {

	int[][] mark;
    
    public boolean exist(char[][] board, String word) {
        
        if(board == null || board.length == 0) return false;
        if(word.length() == 0) return true;
        
        mark = new int[board.length][board[0].length];
        
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(word.charAt(0) == board[i][j]) {
                    boolean rst = find(board, i, j, word, 0);
                    if(rst) return true;
                }
            }
        }
        return false;
    }
    
    public boolean find(char[][] board, int ii, int jj, String word, int index) {
        if(index == word.length()) return true;
        
        if(ii < 0 || ii >= board.length || jj < 0 || jj >= board[0].length || board[ii][jj] != word.charAt(index)) {
            return false;
        }
        if(mark[ii][jj] == 1) return false;
        
        mark[ii][jj] = 1;
        boolean res = find(board, ii-1, jj, word, index+1) || find(board, ii, jj-1, word, index+1) || find(board, ii+1, jj, word, index+1) || find(board, ii, jj+1, word, index+1);
        mark[ii][jj] = 0;
        return res;
    }

}
