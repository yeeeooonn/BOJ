import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] isHave = new int[26];

        String str = br.readLine();

        int startPoint = 0;
        int endPoint = 0;
        int count = 0; //알파벳 종류 개수
        int answer = 0;

        while(true) {
            int endNum = str.charAt(endPoint)-'a';
            int startNum = str.charAt(startPoint)-'a';

            if(count < N) {
                if (isHave[endNum] == 0) {
                    //가지고 있지 않은 경우
                    count++;
                }
                answer = Math.max(answer, endPoint - startPoint+1);
                endPoint++;
                isHave[endNum] +=1;
            }else if(isHave[endNum] > 0) {
                //다음 문자가 이미 나온 문자이면
                answer = Math.max(answer, endPoint - startPoint+1);
                endPoint++;
                isHave[endNum] +=1;
            }else {
                //startPoint를 증가
                if(isHave[startNum] == 1) {
                    count--;
                }
                isHave[startNum] -= 1;
                startPoint++;

            }

            if(endPoint == str.length()) {
                break;
            }

        }
        System.out.println(answer);

    }
}