class Solution {
    static int[] dr = {1,-1,0,0};
    static int[] dc = {0,0,1,-1};
    static int rowLen;
    static int colLen;
    
    public boolean exist(char[][] board, String word) {
        rowLen = board.length;
        colLen = board[0].length;

        // step1. 모든 좌표 완전 탐색
        for(int r = 0; r < rowLen; r++) { 
            for(int c = 0; c < colLen; c++ ){
                //step2. 첫글자 같은지점 찾기.
                if(word.charAt(0) == board[r][c]) { // word의 첫글자 == board의 원소값 부터가 시작.
                    // 직전에 사용한 board의 단어는 제외해서 생각해야하므로. swap방식이용해 잠시 빈값(' ')으로 처리.
                    // a b c -> b (x) 는 이동후 직전의 값은 허용 x
                    char temp = board[r][c];
                    board[r][c]= ' '; 
                    // step3. 찾은 지점에서 상하좌우 백트래킹 시도.
                    if(backtrack(r,c,board,word,1)) {  // 문자 1개 찾았으므로 depth = 1 값 넣기.
                        return true;
                    }
                    board[r][c] = temp;
                }
            }
        }
        return false;
    }

    public static boolean backtrack(int r, int c, char[][] board, String word, int depth) {
        // step4. basecase 설정.(모든글자 다 찾으면 true;)
        if(word.length() == depth) {  
            return true;
        }
        // step5. 상하좌우 백트래킹 시도. 
        for(int i = 0; i < 4; i++) {
            int nextRow = r + dr[i];
            int nextCol = c + dc[i];
            if(isValid(nextRow, nextCol)) { // 벽안에있고
                //  board 행렬 원소값 == word단어(위치값)
                if((board[nextRow][nextCol] == word.charAt(depth)) ) { 
                    char temp = board[nextRow][nextCol];
                    board[nextRow][nextCol] = ' '; 
                    if (backtrack(nextRow, nextCol, board, word, depth+1)) {
                        return true;
                    }
                    board[nextRow][nextCol] = temp;
                }
            }
        }
        return false;
    }
    public static boolean isValid(int r, int c) { // 벽안에있는지 유무 boolean
        return ((0 <= r && r < rowLen) && (0<= c && c < colLen));
    }
}