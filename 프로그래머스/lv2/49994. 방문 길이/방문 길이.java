class Solution {
    static int[] dr = {-1,0,1,0};
    static int[] dc = {0,1,0,-1};
    public int solution(String dirs) {
        int answer = 0;
        boolean[][][] map = new boolean[11][11][4]; //위에서 오는 경우, 오, 아래, 왼
        int r = 5;
        int c = 5;
        for(int i = 0; i < dirs.length(); i++) {
            char move = dirs.charAt(i);
            int d = 0;
            if(move == 'R') d = 1;
            if(move == 'D') d = 2;
            if(move == 'L') d = 3;
            
            int nr = r + dr[d];
            int nc = c + dc[d];
            
            
            if(!check(nr,nc)) continue;
            
            if(map[nr][nc][d] == false) {
                map[nr][nc][d] = true;
                map[r][c][(d+2)%4] = true;
                answer += 1;
            }
            r = nr;
            c = nc;

        }
        
        return answer;
    }
    static boolean check(int nr, int nc) {
        return 0<=nr && nr< 11 && 0<=nc && nc<11;
    }
}