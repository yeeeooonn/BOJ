import java.util.*;

class Solution {
    static int[][] map;
    static int n;
    static int m;

    static List<Integer> answer;
    static int[] dr = {-1,0,1,0};
    static int[] dc = {0,1,0,-1};
    public int[] solution(String[] maps) {
        n = maps.length;
        m = maps[0].length();
        map = new int[maps.length][maps[0].length()];
        answer = new ArrayList<>();

        int[] anwser1 = {};
        
        for(int i = 0; i < maps.length; i++) {
            String str = maps[i];
            for(int j = 0; j< str.length(); j++) {
                char cur = str.charAt(j);
                if(cur == 'X') {
                    map[i][j] = -1;
                }else {
                    map[i][j] = cur-'0';
                }
            }
        }
        
        for(int i = 0; i < maps.length; i++) {
            for(int j = 0; j< maps[0].length(); j++) {
                if(map[i][j] > 0) {
                    bfs(i,j);
                }
            }
        }
        
        
        if(answer.size() == 0) {
            int[] none = {-1};
            return none;
        }
        
        
        int[] result = new int[answer.size()];
        
        for(int i = 0; i<answer.size(); i++) {
            result[i] = answer.get(i);
        }
        Arrays.sort(result);
        
        return result;
    }
    public void bfs(int r, int c) {
        int count = map[r][c];
        map[r][c] = 0;
        
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{r,c});
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            
            for(int d = 0; d < 4; d++) {
                int nr = cur[0] + dr[d];
                int nc = cur[1] + dc[d];
                
                if(!check(nr,nc)) continue;
                
                if(map[nr][nc] > 0) {
                    count+= map[nr][nc];
                    map[nr][nc] = 0;
                    q.offer(new int[] {nr,nc});
                }
            }
        }
        answer.add(count);
        
    }
    public boolean check(int nr, int nc) {
        return 0<=nr && nr<n && 0<=nc && nc< m;
    }
}