import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        perm("");
  
    }

    private static void perm(String str) {
        if(str.length() == N) {
            System.out.println(str);
            System.exit(0);
        }
        for (int i = 1; i <= 3; i++) {
            if(check(str+i)) {
                perm(str+i);
            }
        }


    }

    private static boolean check(String str) {
        for (int i = 1; i <= str.length()/2 ; i++) {
            String f = str.substring(str.length() - i * 2, str.length() - i);
            String b = str.substring(str.length() - i, str.length());
            if(f.equals(b)) {
                return false;
            }

        }

        return true;
    }
}