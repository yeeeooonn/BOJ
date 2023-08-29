class Solution {
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        
        int num = 0; //0~ 차례대로 숫자 늘림
        int digit = 0;//자리수
        while(true) {
            //num을 n진법으로 변환(문자)
            String changeNum = Integer.toString(num, n);
            
            for(int i = 0; i < changeNum.length(); i++) {
                digit += 1; //자리 수 늘리고
                // System.out.println("digit => "+digit+" t="+t+" m="+m+" p="+p);
                if((m!=p && digit%m == p) ||  (m==p && digit%m == 0)) {
                    char c = changeNum.charAt(i);
                    if('a'<=c && c<= 'f') {
                        answer += Character.toUpperCase(c);
                    } else {
                        answer += changeNum.charAt(i);
                    }
                    if(answer.length() == t) {       
                        break;
                    }
                    // System.out.println("요기 => "+answer);
                }
            }
            num++;
            if(answer.length() == t) {       
                break;
            }
        }

        return answer;
    }
}