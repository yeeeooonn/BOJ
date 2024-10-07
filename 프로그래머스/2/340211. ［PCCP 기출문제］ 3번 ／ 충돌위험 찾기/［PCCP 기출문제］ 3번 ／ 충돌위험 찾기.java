import java.util.*;
class Solution {
    static boolean[][] isHere; //로봇이 위치하고 있는지
    static boolean[][] isBoom; //충돌이 일어난 구간인지확인
    static class E {
        int x;
        int y;
        int num; //몇번째 로봇인지 1~n
        int dest; //현재 목적지 1~n
        public E(int x, int y, int num, int dest) {
            this.x = x;
            this.y = y;
            this.num = num;
            this.dest = dest;
        }
    }    
    public int solution(int[][] points, int[][] routes) {
        int answer = 0;
        
        Queue<E> q = new LinkedList<E>();
        
        isHere = new boolean[101][101];
        isBoom = new boolean[101][101];
        
        for(int i = 0; i < routes.length; i++) {
            if(isHere[points[routes[i][0]-1][0]][points[routes[i][0]-1][1]] && !isBoom[points[routes[i][0]-1][0]][points[routes[i][0]-1][1]] ){
                answer++;
                isBoom[points[routes[i][0]-1][0]][points[routes[i][0]-1][1]] = true;
            }
            isHere[points[routes[i][0]-1][0]][points[routes[i][0]-1][1]] = true;
            q.offer(new E(points[routes[i][0]-1][0], points[routes[i][0]-1][1], (i+1), 1));
        }
        
        
        
        while(!q.isEmpty()) {
            int size = q.size();
            isHere = new boolean[101][101];
            isBoom = new boolean[101][101];
            
            for(int i = 0; i < size; i ++) {
                E cur = q.poll();
                //움직이기
                int destX = points[routes[cur.num-1][cur.dest]-1][0];
                int destY = points[routes[cur.num-1][cur.dest]-1][1];
                int nr = cur.x;
                int nc = cur.y;
                
                if(cur.x != destX) {
                    if(cur.x < destX) {
                        //x값을 더 크게 이동
                        nr+=1;
                    }else {
                        nr-=1;
                    }   
                }else if(cur.y != destY){
                    if(cur.y < destY) {
                        nc+=1;
                    }else {
                        nc-=1;
                    }
                    
                }
                
                if(isHere[nr][nc] && !isBoom[nr][nc]) {
                    answer++;
                    isBoom[nr][nc] = true;
                }
                isHere[nr][nc] = true;
                
                //이동 후 목적지가 같다면 목적지 옮기기, 옮길 목적지 없다면 큐에 삽입 x
                if(nr == destX && nc == destY) {
                    //dest+1
                    if(routes[0].length != cur.dest+1) {
                        q.offer(new E(nr,nc,cur.num,cur.dest+1));
                    }
                }else {
                    q.offer(new E(nr,nc,cur.num,cur.dest));
                }
                
            }
            
        }
        
        
        
        return answer;
        
        
    }
}