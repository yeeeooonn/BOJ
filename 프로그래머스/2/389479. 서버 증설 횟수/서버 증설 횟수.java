class Solution {
    static int[] serverDown;//해당시간에 종료되는 서버 수
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        
        serverDown = new int[players.length +24];
        
        int cur = 0; //현재 켜진 서버 수
        int needServer = 0;
        for(int i = 0; i < players.length; i++) {
            cur -= serverDown[i];
            
            needServer = players[i]/m;
            if(cur < needServer) {
                //서버가 필요하면 증설 후 꺼지는 포인트 저장
                int sub = needServer - cur;
                answer += sub;
                cur += sub;
                serverDown[i+k] += sub;
            }
            
            
        }
        
        
        
        return answer;
    }
}