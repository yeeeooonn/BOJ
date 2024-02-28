import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    static long N,K,answer,total;
    static PriorityQueue<Long> Lqueue;
    static PriorityQueue<Long> Hqueue;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= T ; t++) {
            sb.append("#").append(t).append(" ");
            Lqueue = new PriorityQueue<>(Collections.reverseOrder()); //내림차순
            Hqueue = new PriorityQueue<>(); //오름차순

            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            answer = 0;
            total = 0;

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                long num = Long.parseLong(st.nextToken());
                total += num;
                if(num <= K) {
                    Lqueue.add(num);
                }else {
                    Hqueue.add(num);
                }
            }

            //보유 함선 수 에서 제일 가까운 주민 수(보유함선보다 넘지 않는)의 행성을 먼저 침략하고, 동원한다.
            for (int n = 0; n < N; n++) { //최대 N번 동원
                if(K >= total) { //현재 K가 침량해야 할 주민 수 보다 많거나 같으면 더 이상 동원하지 않아도 된다.
                    sb.append(answer).append("\n");
                    break;
                }

                //Hqueue 에서 K보다 작거나 같은거 다 Lqueue로 보냄
                while (true) {
                    if(!Hqueue.isEmpty() && Hqueue.peek() <= K) {
                        Lqueue.add(Hqueue.poll());
                    }else {
                        break;
                    }
                }

                //Lqueue 에서 poll한 값을 침공
                if(Lqueue.isEmpty()) {
                    sb.append(-1).append("\n");
                    break;
                }
                long num = Lqueue.poll();
                answer++;
                K += num;
                total -= num;
            }
        }

        System.out.println(sb);

    }
}