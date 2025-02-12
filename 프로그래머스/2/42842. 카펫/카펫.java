import java.util.*;
class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int sum = brown + yellow;
        
        for(int i = 2; i <= Math.sqrt(sum); i++) {
            //i X (sum/i) 크기의 직사각형
            if(sum%i == 0) {
                int countB = i*2 + (sum/i)*2 - 4; //테두리 개수
                if(countB == brown) {
                    answer[0] = (sum/i);
                    answer[1] = i;
                    break;
                }
            }

        }
        
        return answer;
    }
}