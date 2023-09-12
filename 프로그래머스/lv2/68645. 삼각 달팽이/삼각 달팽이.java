class Solution {
    static int[] dx = {1, 0, -1}; //아래, 옆(오른쪽) 위
    static int[] dy = {0, 1, -1};

    public int[] solution(int n) {
        int[][] board = new int[n][n];
        int num = 1;
        int x = 0;
        int y = 0;
        int d = 0; //방향
        while (true){
            board[x][y] = num++;
            
            int nx = x + dx[d];
            int ny = y + dy[d];
            
            if(nx == n || ny == n || board[nx][ny] != 0){ //끝이거나 값이 있으면 방향바꿈
                d = (d + 1) % 3;
                nx = x + dx[d];
                ny = y + dy[d];
                if(nx == n || ny == n || board[nx][ny] != 0)
                    break;
            }
            x = nx;
            y = ny;
        }
        
        
        
        int[] result = new int[num-1];
        int index = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j <= i; j++){
                result[index++] = board[i][j];
            }
        }
        return result;
    }
}