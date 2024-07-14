class Solution {
    public void solveSudoku(char[][] board) {
		    //step1. 재귀로 모든 board 순회( 시작은 0 )
        backtrack(board, 0);
    }
    public static boolean backtrack(char[][] board, int n) {
	    
		   for(int r = 0; r < 9; r++) {
			   for(int c = 0; c < 9 ; c++) {
				   if(board[r][c] == '.') {
					   for(char num = '1'; num <= '9'; num++) {
						   if(isValid(r, c, num, board)) {
							   board[r][c] = num;
							   if(backtrack(board, n+1)) return true;
							   board[r][c] = '.';
						   }
					   }
					   
					   return false;
				   }
			   }
		   }
		   
		   return true;
    }
		public static boolean isValid(int r, int c, char num, char[][] board) {
			for(int i = 0; i < 9; i++) {
				if(board[i][c] == num || board[r][i] == num) return false;
				if(board[(r/3) * 3 + i /3][(c/3) * 3 + i % 3] == num) return false;
			}
			return true;
	  }
}