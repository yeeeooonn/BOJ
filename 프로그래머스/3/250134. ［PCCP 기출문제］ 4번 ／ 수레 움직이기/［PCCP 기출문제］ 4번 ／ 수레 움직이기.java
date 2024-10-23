class Solution {
    static int answer, redStartX, redStartY, blueStartX, blueStartY; //, redEndX, redEndY, blueEndX, blueEndY;
    static boolean[][] visitedR,visitedB;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    public int solution(int[][] maze) {
        answer = 10000;
        visitedR = new boolean[maze.length][maze[0].length];
        visitedB = new boolean[maze.length][maze[0].length];
        for(int i = 0;i < maze.length; i++) {
            for(int j = 0; j < maze[0].length; j++) {
                if(maze[i][j] == 1) {
                    redStartX = i;
                    redStartY = j;
                }else if(maze[i][j] == 2) {
                    blueStartX = i;
                    blueStartY = j;
                }
                
            }
        }
        
        visitedR[redStartX][redStartY] = true;
        visitedB[blueStartX][blueStartY] = true;
        //몇번째 이동인지, red좌표, blue좌표, red도착여부, blue도착여부, map, red방문배열, blue방문배열
        dfs(0, redStartX, redStartY, blueStartX, blueStartY, false, false, maze, visitedR, visitedB);
        
        
        if(answer == 10000) return 0;
        else return answer;
    }
    static void dfs(int depth, int rx, int ry, int bx, int by, boolean rA, boolean bA, int[][] maze, boolean[][] vR, boolean[][] vB) {
        
         //System.out.println("들어옴 ===>" +depth+" ("+rx+", "+ry+")  ("+bx+", "+by+")");
     
        if(rA && bA) {
            //System.out.println("도착 ---> "+depth+" ("+rx+", "+ry+")  ("+bx+", "+by+")");
            answer = Math.min(answer, depth);
            return;
        }
        
        if(!rA) {
            //1. 빨간수레 출발
            int countR = 0;
            for(int d = 0; d < 4; d++) {
                int rnx = rx + dx[d];
                int rny = ry + dy[d];
                
                if(!check(rnx, rny, maze) || maze[rnx][rny] == 5 || vR[rnx][rny] || (bA && bx == rnx && by == rny)) {
                    //벽이나 격자판 밖, 이미 방문했던 곳, 파랑이 도착상태일 때 고정일 경우면 못감
                    countR++;
                    continue;
                }
                
                if(!bA) {
                    //2. 파란수레 출발
                    int countB = 0;
                    for(int f = 0; f < 4; f++) {
                        int bnx = bx + dx[f];
                        int bny = by + dy[f];
                        if(!check(bnx, bny, maze) || maze[bnx][bny] == 5 || vB[bnx][bny] || (rnx == bnx && rny == bny) || (rx == bnx && ry == bny && bx == rnx && by == rny)) {
                            //벽이나 격자판 밖, 이미 방문했던 곳, 현재 레드위치, 레드와 자리가 서로 바뀐경우면 못감
                            countB++;
                            continue;
                        }

                        vR[rnx][rny] = true;
                        vB[bnx][bny] = true;
                        if(maze[rnx][rny] == 3 && maze[bnx][bny] == 4) {
                            dfs(depth+1, rnx, rny, bnx, bny, true, true, maze, vR, vB);
                        }else if(maze[rnx][rny] == 3 && maze[bnx][bny] != 4) {
                            dfs(depth+1, rnx, rny, bnx, bny, true, false, maze, vR, vB);
                        }else if(maze[rnx][rny] != 3 && maze[bnx][bny] == 4) {
                            dfs(depth+1, rnx, rny, bnx, bny, false, true, maze, vR, vB);
                        }else {
                            dfs(depth+1, rnx, rny, bnx, bny, false, false, maze, vR, vB);
                        }
                        vR[rnx][rny] = false;
                        vB[bnx][bny] = false;

                    }

                }else {
                    //빨간색이동, 파란색은 이미 도착인 경우
                    vR[rnx][rny] = true;
                    if(maze[rnx][rny] == 3) {
                        dfs(depth+1, rnx, rny, bx, by, true, true, maze, vR, vB);
                    }else {
                        dfs(depth+1, rnx, rny, bx, by, false, true, maze, vR, vB);
                    }
                    vR[rnx][rny] = false;
                }
                
                
            }
            
        }else {
            //3. red가 이미 도착인 경우 파란수레 출발
            int countB = 0;
            for(int d = 0; d < 4; d++) {
                int bnx = bx + dx[d];
                int bny = by + dy[d];
                if(!check(bnx, bny, maze) || maze[bnx][bny] == 5 || vB[bnx][bny] || (rx == bnx && ry == bny)) {
                    //벽이나 격자판 밖, 이미 방문했던 곳, 현재 레드위치면 못감
                    countB++;
                    continue;
                }

                vB[bnx][bny] = true;
                if(maze[bnx][bny] == 4) {
                    dfs(depth+1, rx, ry, bnx, bny, true, true, maze, vR, vB);
                }else {
                    dfs(depth+1, rx, ry, bnx, bny, true, false, maze, vR, vB);
                }
                vB[bnx][bny] = false;

            }
        }
    }
    static boolean check(int nr, int nc, int[][] maze) {
        return nr>=0 && nc>=0 && nr< maze.length && nc<maze[0].length;
    }
}