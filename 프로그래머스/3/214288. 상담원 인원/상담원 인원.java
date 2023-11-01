import java.util.*;

class Solution {
    static ArrayList<int[]> consultant;
    static int[] consultantCount;
    static int[][] mentors;
    static int answer = Integer.MAX_VALUE / 100;
    
    public int solution(int k, int n, int[][] reqs) {
        consultantCount = new int[k];
        mentors = reqs;
        
        perm(0, k, n);
        
        return answer;
    }
    
    public void perm(int n, int cnt, int leftCnt) {
        if(n == cnt-1) {
            consultantCount[n] = leftCnt;
            
            
            consultant = new ArrayList<>();
            
            for(int i = 0; i < cnt; i++) {
                consultant.add(new int[consultantCount[i]]);    
            }
            
            solve();
            
            return;
        }
        
        for(int i = 1; i < leftCnt; i++) {
            consultantCount[n] = i;
            perm(n+1, cnt, leftCnt-i);
        }
    }
    
    public void solve() {
        int sumWait = 0;
        
        for(int i = 0; i < mentors.length; i++) {
            int idx = 0;
            int leastWait = consultant.get(mentors[i][2]-1)[0] - mentors[i][0];
            
            if (leastWait < 0) {
                leastWait = 0;
            }
            
            for(int j = 1; j < consultant.get(mentors[i][2]-1).length; j++) {
                int tmp = consultant.get(mentors[i][2]-1)[j] - mentors[i][0];
                
                if(tmp < 0) tmp = 0; 
                
                if(leastWait > tmp) {
                    idx = j;
                    leastWait = tmp;
                }
            }
            
            if (leastWait == 0) {
                consultant.get(mentors[i][2]-1)[idx] = (mentors[i][0] + mentors[i][1]);
            } else {
                consultant.get(mentors[i][2]-1)[idx] += mentors[i][1];
            }
            
            sumWait += leastWait;
        }
        
        answer = Math.min(answer, sumWait);
    }
}