import java.util.*;

class Solution {
    public int solution(int[] topping) {
        HashMap<Integer,Integer> hm1 = new HashMap<Integer,Integer>();
        HashMap<Integer,Integer> hm2 = new HashMap<Integer,Integer>();
        int answer = 0;
        
        hm1.put(topping[0],1);
        
        for(int i = 1; i< topping.length; i++) {
            int top = topping[i];
            if(hm2.get(top) == null) {
                hm2.put(top,1);
            }else {
                hm2.put(top, hm2.get(top)+1);
            }
        }
        
        for(int i = 1; i< topping.length; i++) {
            if(hm1.size() == hm2.size()) {
                answer++;
            }
            
            //다음 위치로 변경
            int nextTop = topping[i];
            if(hm1.get(nextTop) == null) {
                hm1.put(nextTop,1);
            }else {
                hm1.put(nextTop, hm1.get(nextTop)+1);
            }
            
            if(hm2.get(nextTop)== 1) {
                hm2.remove(nextTop);
            }else {
                hm2.put(nextTop, hm2.get(nextTop)-1);
            }
        }
        
        
        return answer;
    }
}