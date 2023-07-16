import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        int sizeQ = queue1.length;
        
        long sum1 = 0,sum2 = 0;
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        
        for(int i = 0; i < sizeQ; i++) {
            sum1 += queue1[i];
            sum2 += queue2[i];
            q1.offer(queue1[i]);
            q2.offer(queue2[i]);
        }
        
        while(3*sizeQ >= answer) { //3*큐사이즈 까지 합이 안같아지면 -1 반환
            if(sum1 == sum2) {
                return answer;
            }
            if(sum1 < sum2) { //sum1이 작은 경우
                long peekNum = q2.peek();
                q1.offer(q2.poll());
                sum1 += peekNum;
                sum2 -= peekNum;
            }else {
                long peekNum = q1.peek();
                q2.offer(q1.poll());
                sum2 += peekNum;
                sum1 -= peekNum;
            }
            answer++;
        } 
        
        return -1;
    }
}