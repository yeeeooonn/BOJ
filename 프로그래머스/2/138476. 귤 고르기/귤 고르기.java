import java.util.*;

class Solution {
    class E implements Comparable<E> {
        int size;
        int num;
        public E(int size, int num) {
            this.size = size;
            this.num = num;
        }
        
        @Override
        public int compareTo(E e) {
            return e.num - this.num;
        }
    }
    public int solution(int k, int[] tangerine) {
        
        Arrays.sort(tangerine);
        PriorityQueue<E> pq = new PriorityQueue<>(); //귤 개수 순으로 정렬
        
        int before = tangerine[0];
        int count = 1;
        if(tangerine.length == 1) { //귤 개수가 1일경우 처리
            pq.offer(new E(before, count));
        }
        
        for(int i = 1; i < tangerine.length; i++) {
                        
            if(tangerine[i] != before) {
                pq.offer(new E(before, count));
                before = tangerine[i];
                count = 1;
            }else {
                count++;
            }
            
            if(i == tangerine.length -1) {
                pq.offer(new E(before, count));
            }
            
        }
        
        
        int answer = 0;
        int select = 0; //현재 꺼낸 귤 개수
        while(true) {
            E cur = pq.poll();
            select += cur.num;
            answer++;
            
            if(select >= k) {
                break;
            }
            
        }
        
        
        
        return answer;
    }
}