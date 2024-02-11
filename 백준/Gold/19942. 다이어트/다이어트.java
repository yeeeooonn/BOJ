import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int[] min; //최소 식재료 배열
    static int[][] info; // 단 지 탄 비, 가격,
    static int answer = Integer.MAX_VALUE;
    static List<String> list;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        min = new int[4];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            min[i] = Integer.parseInt(st.nextToken());
        }
        info = new int[N][5];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                info[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        boolean[] select = new boolean[N];
        list = new ArrayList<>();

        choice(0,0,0,0,0,0, select); //depth, 단 지 탄 비, 가격, 선택 음식

        if(answer == Integer.MAX_VALUE) {
            sb.append(-1);
        }else {
            sb.append(answer).append("\n");
            Collections.sort(list);
            String str = list.get(0);
            sb.append(str);
            for (int i = 0; i < str.length(); i++) {
            }

        }
        System.out.println(sb);

    }
    static void choice(int depth, int a, int b, int c, int d, int price, boolean[] select) {
        if(depth == N) {
            if(price <= answer && check(a,b,c,d)) {
                if(price < answer) {
                    list.clear();
                }
                String str = "";
                for (int i = 0; i < N; i++) {
                    if(select[i]) {
                        str += (i+1);
                        str += " ";
                    }
                }
                list.add(str);
                answer = Math.min(answer, price);
            }
            return;
        }



        //선택함
        select[depth] = true;
        choice(depth+1, a+info[depth][0], b+info[depth][1], c+info[depth][2], d+info[depth][3], price+info[depth][4], select);
        select[depth] = false;

        //선택안함
        choice(depth+1, a, b, c, d, price, select);

    }

    private static boolean check(int a, int b, int c, int d) {
        return min[0] <= a && min[1]<=b && min[2]<=c && min[3]<=d;
    }
}