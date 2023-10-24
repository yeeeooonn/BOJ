import java.util.*;
class Solution {
    static int answer;
    static int userNum;
    static int bannNum;
    static int[] select;
    static int[] copy;
    static String[] user;
    static String[] banned;
    static boolean[] visited;
    static HashMap<String, Integer> hm; 
    public int solution(String[] user_id, String[] banned_id) {
        
        userNum = user_id.length;
        bannNum = banned_id.length;
        user = user_id;
        banned = banned_id;
        select = new int[bannNum];
        copy = new int[bannNum];
        visited = new boolean[userNum];
        hm = new HashMap<>();
        
        for(int i = 0; i < select.length; i++) {
            select[i] = -1;
        }
        
        answer = 0;
        perm(0);
        
        return answer;
    }
    static void perm(int cnt){
        if(cnt == bannNum) {
            
            
            if(check(select)) {
                
                StringBuilder sb = new StringBuilder();

                for(int i = 0; i < copy.length; i++) {
                    copy[i] = select[i];
                }
                
                Arrays.sort(copy);
                
                for(int i = 0; i < copy.length; i++) {
                    sb.append(copy[i]);
                }
                
                if(hm.containsKey(sb.toString())) {
                    return;
                }

                answer++;
                hm.put(sb.toString(), 1);

            }
            
            return;
        }
        for(int i = 0; i< userNum; i++) {
            if(visited[i]) continue;
            visited[i] = true;
            select[cnt] = i;
            perm(cnt+1);
            select[cnt] = -1;
            visited[i] = false;
        }
    }
    static boolean check(int[] select) {
        //맞는지 확인
        
        for(int i = 0; i < select.length; i++) {
            String S = user[select[i]];
            String B = banned[i];
            
            if(S.length() != B.length()) {
                return false;
            }
            
            for(int j = 0; j < S.length(); j++) {
                
                if(B.charAt(j) == '*') continue;
                if(S.charAt(j) != B.charAt(j)) {
                    return false;
                }
                
            }
            
        }
        
        return true;
    }
}