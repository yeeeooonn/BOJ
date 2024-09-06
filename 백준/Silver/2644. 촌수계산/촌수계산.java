import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N,T;
    static int s,e,result;
    static int[] parent; //부모 번호 저장
    static int[] sNum; //부모 촌수 저장(첫번째 사람)
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        parent = new int[N+1];
        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            parent[c] = p;
        }

        sNum = new int[N+1];//-1로 초기화 : 지난적 없으면 -1
        for (int i = 0; i < N+1; i++) {
            sNum[i] = -1;
        }
        result = -1;

        int point = s;
        int add = 0;
        while(point != 0) {
            sNum[point] = add;
            add++;
            point = parent[point];
        }

        point = e;
        add = 0;
        while(point != 0) {
            if(sNum[point] != -1) {
                //만난거
                result = (add + sNum[point]);
                break;
            }
            add++;
            point = parent[point];
        }

        System.out.println(result);

    }
}