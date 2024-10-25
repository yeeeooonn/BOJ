import java.util.*;

class Solution {
    static int curP;
    static Stack<E> s;
    static int count;
    static String[] answer;
    static class E {
        String name;
        int modTime;
        public E(String name, int modTime) {
            this.name = name;
            this.modTime = modTime;
        }
    }
    
    public String[] solution(String[][] plans) {
        
        Arrays.sort(plans, (a,b)-> { //시간순으로 정렬
            int ah = Integer.parseInt(a[1].substring(0,2));
            int bh = Integer.parseInt(b[1].substring(0,2));
            int am = Integer.parseInt(a[1].substring(3,5));
            int bm = Integer.parseInt(b[1].substring(3,5));
            
            if(ah == bh){
                return am - bm;
            }else {
                return ah - bh;
            }
            
        });
        
        s = new Stack<E>();
        count = 0; //현재 완료한 개수
        answer = new String[plans.length];
        
        for(int i = 0; i < plans.length; i++) {
            if(i == plans.length-1) {
                
                //완료, 스택에 있는것들 차례대로 빼서 답에 저장
                answer[count++] = plans[i][0];
                
                while(!s.isEmpty()) {
                    E cur = s.pop();
                    answer[count++] = cur.name;
                }
                
            }else {
                int curM = time(i, plans);
                int nextM = time(i+1, plans);
                int time = Integer.parseInt(plans[i][2]);
                
                
                //다음 과제시작시간보다 작거나 같으면 답 저장&보내주기
                if(curM + time <= nextM) {
                    answer[count++] = plans[i][0];
                    //남은시간만큼 스택에서 빼서 저장
                    
                    int spareTime = nextM - (curM + time);
                    
                    while(!s.isEmpty()) {
                        if(spareTime <= 0) break;
                        
                        E cur = s.pop();
                        
                        if(cur.modTime <= spareTime) {
                            answer[count++] = cur.name;
                            spareTime -= cur.modTime;
                        }else {
                            s.add(new E(cur.name, cur.modTime - spareTime));
                            spareTime -= cur.modTime;
                        }
                        if(spareTime <= 0) break;
                        
                    }

                    
                }else {
                    int modTime = (curM+time) - nextM;
                    //스택에 남은시간과 과제 이름저장
                    s.add(new E (plans[i][0], modTime));
                }
                
            }  
            
        }

        return answer;
    }
    static int time(int i, String[][] plans) {
        return 60 * Integer.parseInt(plans[i][1].substring(0,2)) + Integer.parseInt(plans[i][1].substring(3,5));
    }
}