import java.util.*;
class Solution {
    static int[][] group;
    static int[][] map;
    static int[] dr = {-1,0,1,0};
    static int[] dc = {0,1,0,-1};
    static Map<Integer, Integer> total;
    static boolean[] visited;
    public int solution(int[][] land) {
        
        group = new int[land.length][land[0].length];
        map = new int[land.length][land[0].length];
        total = new HashMap<>();
        
        for(int i = 0; i < land.length; i++) {
           for(int j = 0; j < land[0].length; j++) {
                map[i][j] = land[i][j];
            } 
        }
        
        int number = 1; //그룹 번호
        for(int i = 0; i < land.length; i++) {
           for(int j = 0; j < land[0].length; j++) {
                if(map[i][j] ==1 && group[i][j] == 0) {
                    bfs(i,j,number);
                    number++;
                }
               
            } 
        }
        
        int answer = 0;
        
        for(int i = 0; i < land[0].length; i++) {
            int sum = 0;
            visited = new boolean[number+1];
            for(int j = 0; j < land.length; j++) {
                if(group[j][i] > 0 && !visited[group[j][i]]) {
                    visited[group[j][i]] = true;
                    sum += total.get(group[j][i]);
                }
            }
            answer = Math.max(answer, sum);
        }
        
        
        
        return answer;
    }
    static void bfs(int r, int c, int num) {
        int count = 1;
        group[r][c] = num;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {r,c});
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            for(int d = 0; d < 4; d++) {
                int nr = cur[0] + dr[d];
                int nc = cur[1] + dc[d];
                if(!check(nr, nc)) continue;
                if(map[nr][nc] == 1 && group[nr][nc] == 0) {
                    count++;
                    group[nr][nc] = num;
                    q.offer(new int[] {nr,nc});
                }
            }
        }
        
        total.put(num, count);
        
    }
    static boolean check(int nr, int nc) {
        return nr>=0 && nr< map.length && nc>=0 && nc< map[0].length;
    }
}