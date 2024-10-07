import java.util.*;
class Solution {
    static String[][] map;
    static int[] dr = {1,0,0,-1}; //아, 왼, 오, 위 순
    static int[] dc = {0,-1,1,0};
    static char[] s = {'d','l','r','u'};
    static String answer;
    static class E {
        int x;
        int y;
        int num;
        String str;
        public E(int x, int y, int num, String str) {
            this.x = x;
            this.y = y;
            this.num = num;
            this.str = str;
        }
    }
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        x = x-1;
        y = y-1;
        r = r-1;
        c = c-1;
    
        answer = "";
        
        map = new String[n][m];
        
        Queue<E> q = new LinkedList<E>();
        q.offer(new E(x,y,0,""));
        
        
        if((Math.abs(x-r) + Math.abs(y-c))%2 != k%2) {
            return "impossible";
        }
        
        dfs(x, y, 0, "", r,c,k,n,m);//현재위치, 이동횟수, 문자열, 도착지점, k,n,m

        if(answer == "") return "impossible";
        else return answer;
        
    }
    static void dfs(int x, int y, int move, String str, int r, int c, int k,int n, int m) {
        // System.out.println(move+"번째 이동 -->"+x+" "+y+" "+" "+str);
        if(x ==r && y ==c && move == k) {
            // System.out.println("여기 도착-1");
            answer = str;
            return;
        }
        
        for(int d =  0; d<4; d++) {
            int nr = x + dr[d];
            int nc = y + dc[d];
            if(!check(nr,nc,n,m)) continue;
            // System.out.println("체크 이동 횟수 : "+move);
            // System.out.println("체크"+d+" ----> "+nr+" "+nc+" "+map[nr][nc]);
            if((map[nr][nc]==null || map[nr][nc].length() < str.length()) && isPossible(nr,nc,move,r,c,k)) {
                map[nr][nc] = str;
                dfs(nr,nc,move+1,str+s[d],r,c,k,n,m);
            }
        }
        
        
    }

    static boolean check(int nr,int nc,int n,int m) {
        return nr>=0 && nr<n && nc>=0 && nc<m;
    }
    static String compare(String a, String b) {
        // System.out.println(a+"   "+b);
        for(int i = 0; i< Math.min(a.length(), b.length()); i++) {
            char ac = a.charAt(i);
            char bc = b.charAt(i);
            if(ac < bc) {
                return a;
            }else if(ac > bc) {
                return b;
            }
        }
        return a;
    }
    static boolean isPossible(int nr,int nc,int num,int r,int c, int k) {
        int nes = Math.abs(nr - r) + Math.abs(nc -c);
        return nes <= k-num; 
    }
}