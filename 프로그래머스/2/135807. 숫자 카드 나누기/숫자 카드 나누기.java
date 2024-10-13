import java.util.*;
class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        
        Arrays.sort(arrayA);
        Arrays.sort(arrayB);
        
        int minA = arrayA[0];
        int minB = arrayB[0];
        
        List<Integer> nums = new ArrayList<>();
        
        for(int i = 2; i <=minA; i++) {
            if(minA%i == 0) {
                nums.add(i);
            }
        }
  
        //철수확인
        for(int i = 0; i < nums.size(); i++) {
            int num = nums.get(i);
            
            boolean isModC = false;
            for(int j = 0; j <arrayA.length; j++) {
                if(arrayA[j]%num != 0) {
                    isModC = true;
                }
            }
            
            boolean isModY = true;
            if(!isModC) {
                //영희 확인
                for(int j = 0; j <arrayB.length; j++) {
                    if(arrayB[j]%num == 0) {
                        isModY = false;
                    }
                }
            }else continue;
            
            if(isModY) {
                answer = Math.max(answer, num);
            }
        }
        
        nums = new ArrayList<>();
        for(int i = 2; i <=minB; i++) {
            if(minB%i == 0) {
                nums.add(i);
            }
        }
        
        //영희 확인
        for(int i = 0; i < nums.size(); i++) {
            int num = nums.get(i);
            
            boolean isModY = false;
            for(int j = 0; j <arrayB.length; j++) {
                if(arrayB[j]%num != 0) {
                    isModY = true;
                }
            }
            
            boolean isModC = true;
            if(!isModY) {
                //철수 확인
                for(int j = 0; j <arrayA.length; j++) {
                    if(arrayA[j]%num == 0) {
                        isModC = false;
                    }
                }
            }else continue;
            
            if(isModC) {
                answer = Math.max(answer, num);
            }
        }
        
        return answer;
    }
}