class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();

				// n * n board생성
        char[][] board = new char[n][n];
        int rowLen = board.length;
        int colLen = board[0].length;
        
        for(int r = 0; r < rowLen; r++) {
            for(int c =0 ; c < colLen; c++) {
                board[r][c] = '.'; //모두다 . 으로 채움.
            }
        }


        backtrack(new ArrayList<>(), 0, n, board, ans);
        
        return ans;

    }
    public static void backtrack(List<String> curr, int r, int n, char[][] board, List<List<String>> ans) {
        int rowLen = board.length;
        int colLen = board[0].length;

		// 현재 퀸의개수와 n이 같으면 체스판 추가.
        if(r == n) {
		        ans.add(new ArrayList<>(curr));
            return ;
        }
        // row는 정해졋고 col을 순회
        for(int c = 0; c < colLen; c++) {
            if(isValid(r, c, board)) {
                board[r][c] = 'Q';
                curr.add(new String(board[r]));
                backtrack(curr, r+1, n, board, ans);
                curr.remove(curr.size()-1);
                board[r][c] = '.';// 재귀 끝나면
            }
        }
    }
    public static boolean isValid(int r, int c, char[][] board) {
        int rowLen = board.length;
        int colLen = board[0].length;
		// 열 확인 ⬆️
        for(int curRow = 0; curRow < r; curRow++) {
            if(board[curRow][c] == 'Q') return false;
        }
		// 왼쪽 대각선 확인. ↖️
		// row-1은 위로한칸, col-1은 왼쪽한칸
        for(int curRow = (r -1), curCol = (c - 1) ; 0 <= curRow && 0 <= curCol ; curRow--, curCol--) {
            if(board[curRow][curCol] == 'Q') return false;
        }
     		
		// 오른쪽 대각선 확인. ↗️
		// row -1 은 위로한칸, col+1은 오른쪽 한칸
        for(int curRow = r - 1,  curCol = c + 1; 0 <= curRow && curCol < colLen; curRow--, curCol++) {
            if(board[curRow][curCol] == 'Q') return false;
        }
        return true;
    }
}