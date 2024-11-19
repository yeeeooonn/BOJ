class Solution {
    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        
        int startTime = h1*3600 + m1*60 + s1;
        int endTime = h2*3600 + m2*60 + s2;
        
        
        int answer = 0;

        if((h1 == 0 || h1 == 12) && m1 == 0 && s1 == 0) answer++;
        
        
        while(startTime < endTime) {
            
            double hD = (startTime/(double)120)%360;
            double mD = (startTime/(double)10)%360;
            double sD = (startTime*6)%360;
            
            double hDN = ((startTime+1)/(double)120)%360;
            double mDN = ((startTime+1)/(double)10)%360;
            double sDN = ((startTime+1)*6)%360;
            
            
            //각도가 0도면 360도로 계산
            if(hDN == 0) hDN = 360;
            if(mDN == 0) mDN = 360;
            if(sDN == 0) sDN = 360;
            
            if(sD < hD && sDN >= hDN) answer++;
            if(sD < mD && sDN >= mDN) answer++;
            if(hDN == mDN)answer--; //중복제거
            
            
            startTime += 1;
        }



        return answer;
    }
}