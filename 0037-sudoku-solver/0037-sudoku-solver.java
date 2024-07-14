class Solution {
    public void solveSudoku(char[][] board) {
		    //step1. 재귀로 모든 board 순회( 시작은 0 )
        backtrack(board, 0);
    }
    public static boolean backtrack(char[][] board, int n) {
		    //step2. 현재, row, col 각각 구하기.
        int row = n / 9; 
        int col = n % 9;
	
				// step3. basecase설정
        if(n == 81) return true; // 마지막이면 반환
        // step4. 마침표로 분기처리
        if(board[row][col] == '.') { 
		        // 숫자 비어있으면 1~9 에대해 유효성검사
            for(char num = '1'; num <= '9'; num++) {
                if(isValid(row, col, num, board)) {
                    board[row][col] = num;
                    if(backtrack(board, n+1)) return true; // n+1 은 오른쪽으로 이동.
                    board[row][col] = '.';
                }
            }
            return false;
        } else {
		        // 숫자 안비어있으면 다음 보드 탐색.
            return backtrack(board, n+1);
        }
    }
    public static boolean isValid(int row, int col, int num ,char[][] board) {
        for(int i =0 ;i < 9 ;i++) {
            // 가로 ,세로 같은숫자있는지 판단  (이미 사용된적있는수이면 false반환)
            if( (board[i][col] == num) || (board[row][i] == num) ) return false;


            // 3*3안에서 이미 사용된적있는 수이면 false반환 (풀이 1) - 시간 세이브됨.(나의풀이)
//            int in_row = 3 *(row / 3 ) + (i / 3);
//            int in_col = 3 * (col /3 ) + (i % 3);
//            if(board[in_row][in_col] == num) return false;

            // 3*3안에서 이미 사용된적있는 수이면 false반환( 풀이 2) - 직관적이라 좋음.(해답코드), 대신 for문 또 돌아서 더오래걸림.
            int in_row = 3 * (row / 3);
            int in_col = 3 * (col / 3);
            for(int dr = 0 ; dr <3; dr++)
                for(int dc = 0; dc <3; dc++)
                    if(board[in_row+dr][in_col+dc] == num) return false;
				   
        }
        return true;
        
    }
}