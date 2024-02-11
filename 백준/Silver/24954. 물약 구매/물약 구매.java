import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] price;
    static int[] priceCopy;
    static int[] select;
    static boolean[] check;
    static List<D>[] discount;
    static int answer = Integer.MAX_VALUE;
    static class D {
        int target;
        int discount;
        public D(int target, int discount){
            this.target = target;
            this.discount = discount;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        price = new int[N];
        select = new int[N];
        check = new boolean[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            price[i] = Integer.parseInt(st.nextToken());
        }

        discount = new List[N];
        for (int i = 0; i < N; i++) {
            discount[i] = new ArrayList<>();
        }

        for (int i = 0; i < N; i++) { //할인 입력
            int n = Integer.parseInt(br.readLine());
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                discount[i].add(new D(Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())));
            }

        }

        perm(0); //순열

        System.out.println(answer);


    }

    static void perm(int depth) {
        if(depth == N) {
            int count = 0;
            priceCopy = new int[N];
            System.arraycopy(price, 0, priceCopy, 0, N);

            for (int i = 0; i < N; i++) {
                count += priceCopy[select[i]];
                //할인 적용
                for (int j = 0; j < discount[select[i]].size(); j++) {
                    D d = discount[select[i]].get(j);
                    priceCopy[d.target] = Math.max(1, priceCopy[d.target] - d.discount);
                }

            }
            answer = Math.min(answer, count);

            return;
        }
        for (int i = 0; i < N; i++) {
            if(check[i]) continue;
            check[i] = true;
            select[depth] = i;
            perm(depth+1);
            select[depth] = 0;
            check[i] = false;
        }

    }
}