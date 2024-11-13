import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N,A,B,C;
    static String s;
    static int[] parent;
    static int[] rank;
    static int MAX_NUM = 1_000_001;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        parent = new int[MAX_NUM];
        rank = new int[MAX_NUM];
        for (int i = 0; i < MAX_NUM; i++) {
            parent[i] = i;
            rank[i] = 1;
        }

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            s = st.nextToken();

            if(s.equals("I")) {
                A = Integer.parseInt(st.nextToken());
                B = Integer.parseInt(st.nextToken());
                A = find(A);
                B = find(B);
                if(A == B) continue;

                if(rank[A] < rank[B]) {
                    rank[B] += rank[A];
                    parent[A] = B;
                }else {
                    rank[A] += rank[B];
                    parent[B] = A;
                }


            }else {
                C = Integer.parseInt(st.nextToken());
                sb.append(rank[find(C)]).append("\n");
            }

        }
        System.out.print(sb);


    }
    static int find(int num) {
        if(parent[num] == num ) return num;
        else return parent[num] = find(parent[num]);
    }
}