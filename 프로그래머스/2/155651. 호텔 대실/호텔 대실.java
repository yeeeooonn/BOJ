import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        
        Arrays.sort(book_time, (a,b)->{ //시작순으로 정렬
            if(a[0] == b[0]) {
                int atime = Integer.parseInt(a[1].substring(0,2))*60 + Integer.parseInt(a[1].substring(3,5));
                int btime = Integer.parseInt(b[1].substring(0,2))*60 + Integer.parseInt(b[1].substring(3,5));
                return Integer.compare(atime,btime);

            } else {
                int atime = Integer.parseInt(a[0].substring(0,2))*60 + Integer.parseInt(a[0].substring(3,5));
                int btime = Integer.parseInt(b[0].substring(0,2))*60 + Integer.parseInt(b[0].substring(3,5));
                return Integer.compare(atime,btime);
            }
        });
        
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i = 0; i < book_time.length; i++) {
            
            int startTime = Integer.parseInt(book_time[i][0].substring(0,2))*60 + Integer.parseInt(book_time[i][0].substring(3,5));
            int endTime = Integer.parseInt(book_time[i][1].substring(0,2))*60 + Integer.parseInt(book_time[i][1].substring(3,5));

            if(pq.isEmpty()) {
                pq.offer(endTime);
            }else {
                int fastTime = pq.poll();

                if(fastTime > startTime) { //제일 빨리 종료되는 방보다 시작시작이 빠르면 제거된 방 다시 pq에 추가
                    pq.offer(fastTime);
                }
                pq.offer(endTime+10);
                
            }
            
            
        }
        
        return pq.size();
    }
}