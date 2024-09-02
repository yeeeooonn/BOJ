import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static char[][] tree;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        tree = new char[N][3];


        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            tree[i][0] = st.nextToken().charAt(0);
            tree[i][1] = st.nextToken().charAt(0);
            tree[i][2] = st.nextToken().charAt(0);
        }

        pre(0);
        sb.append("\n");
        in(0);
        sb.append("\n");
        post(0);

        System.out.println(sb);

    }
    static void pre(int depth){
        //루트 노드
        sb.append(tree[depth][0]);
        
        //왼쪽노드
        if(tree[depth][1] != '.') {
            //찾아서 보내고
            for (int i = 0; i < N; i++) {
                if(tree[depth][1] == tree[i][0]) {
                    pre(i);
                    break;
                }
            }
        }


        //오른쪽 노드
        if(tree[depth][2] != '.') {
            //찾아서 보내고
            for (int i = 0; i < N; i++) {
                if(tree[depth][2] == tree[i][0]) {
                    pre(i);
                    break;
                }
            }
        }

    }
    static void in(int depth){
        //왼쪽
        if(tree[depth][1] != '.') {
            //찾아서 보내고
            for (int i = 0; i < N; i++) {
                if(tree[depth][1] == tree[i][0]) {
                    in(i);
                    break;
                }
            }
        }
        //루트
        sb.append(tree[depth][0]);

        //오른쪽
        if(tree[depth][2] != '.') {
            //찾아서 보내고
            for (int i = 0; i < N; i++) {
                if(tree[depth][2] == tree[i][0]) {
                    in(i);
                    break;
                }
            }
        }

    }
    static void post(int depth){

        //왼쪽
        if(tree[depth][1] != '.') {
            //찾아서 보내고
            for (int i = 0; i < N; i++) {
                if(tree[depth][1] == tree[i][0]) {
                    post(i);
                    break;
                }
            }
        }
        //오른쪽
        if(tree[depth][2] != '.') {
            //찾아서 보내고
            for (int i = 0; i < N; i++) {
                if(tree[depth][2] == tree[i][0]) {
                    post(i);
                    break;
                }
            }
        }
        //중앙
        sb.append(tree[depth][0]);

    }
}