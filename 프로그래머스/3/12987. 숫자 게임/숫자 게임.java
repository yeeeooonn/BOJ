import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);
        
        Queue<Integer> q = new LinkedList<>();
        
        int answer = 0;
        
        for(int i = 0; i < A.length; i++) {
            if(A[i] < B[i]) {
                answer++;
            }else {
                //큐에 A숫자를 넣음
                q.offer(A[i]);
                
                //peek해서 B 의현재숫자보다 작다면 큐에서 빼고 answer++
                if(q.peek() < B[i]) {
                    q.poll();
                    answer++;
                }
                
            }
            
        }
        
        return answer;
    }
}