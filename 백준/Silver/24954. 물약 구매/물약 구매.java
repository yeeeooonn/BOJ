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

        perm(0, 0, price); //순서 시작

        System.out.println(answer);


    }

    static void perm(int depth, int count, int[] price) {
        if(depth == N) {
            answer = Math.min(answer, count);
            return;
        }
        if(count > answer) return;
        for (int i = 0; i < N; i++) {
            if(check[i]) continue;
            check[i] = true;
            int p = price[i];

            priceCopy = new int[N];
            System.arraycopy(price, 0, priceCopy, 0, N);

            //할인 시키기
            for (int j = 0; j < discount[i].size(); j++) {
                D d = discount[i].get(j);
                priceCopy[d.target] = Math.max(1, priceCopy[d.target] - d.discount);
            }

            perm(depth+1, count+p, priceCopy);

            check[i] = false;
        }

    }
}