import java.util.*;

class Solution {
    static int[] answer;
    static int diff;
    static int[] peach;
    public int[] solution(int n, int[] info) {
        answer = new int[info.length];
        peach = info.clone();
        
        subset(n, 0, answer); //남은 화살 수, 점수(0~10), 라이언의 배열

        if(diff == 0) { //score 값이 바뀌지 않았다면 -1 배열 리턴
            int[] noResult = {-1};
            return noResult;
        }
        
        return answer;
    }
    public void subset(int count, int depth, int[] ryan) {

        if(depth == 11) { //10 넘어가면 종료 (남은 count를 0 점 에 준다.)
            ryan[10] = count;
            calc(ryan);
            return;
        }
        
        //해당 점수 넘기는 경우
        subset(count,depth+1,ryan);   
        
        if(peach[depth] < count) { //해당 점수의 어피치 점수보다 많이 맞출 수 있으면 점수빼고 subset
            int num = peach[depth] + 1;
            ryan[depth] = num;
            subset(count-num, depth+1, ryan);
            ryan[depth] = 0;
        }
        
    }
    public void calc(int[] ryan) {
        int aScore = 0; //어피치 점수
        int rScore = 0; //라이언 점수
        
        for(int i = 0; i < peach.length; i++) { //계산
            if(ryan[i] == 0 && peach[i] == 0) { //둘다 0이면 넘김
                continue;
            }
            if(ryan[i] > peach[i]) { //라이언이 개수가 더 많은 경우 점수 증가 후 넘김 -> 이부분 로직 수정 필요                                                                                                        
                rScore += (10-i);
            }
            if(peach[i]>= ryan[i]) {
                aScore += (10-i);
            }

        }
        
        int sub = rScore - aScore; //라이언 - 어피치
        
        if(sub >= diff) {//어피치 점수보다 높고, 기존 스코어보다 높거나 같은 경우 값 갱신
            if(sub == diff) { //점수가 같다면 끝부터 비교해서 개수가 더 많은 배열로 변경
                for(int i = 10; i >= 0; i--) {
                    if(ryan[i] == answer[i]) {
                        continue;
                    }
                    if(ryan[i] > answer[i]) {
                        answer = ryan.clone();
                        return;
                    }
                    break;
                }
                
            }else {
                diff = sub;
                answer = ryan.clone();
            }

        }
    }
}