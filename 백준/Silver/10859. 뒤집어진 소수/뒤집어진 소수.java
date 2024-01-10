import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String reverse = "";

        if(str.equals("1")) {
            System.out.println("no");
            return;
        }

        for(int i = str.length()-1; i >= 0; i-- ) {
            int num = Integer.parseInt(str.charAt(i)+"");
            if(num == 3 || num == 4 || num == 7) {
                System.out.println("no");
                return;
            }else if(num == 6) {
                reverse += "9";
            }else if(num == 9) {
                reverse += "6";
            }else {
                reverse += num;
            }
        }

        if(solution(reverse) && solution(str)) {
            System.out.println("yes");
        }else {
            System.out.println("no");
        }

    }
    static boolean solution(String num) {
        long number = Long.parseLong(num);
        for (long i = 2; i <= Math.sqrt(number); i++) {
            if(number%i == 0) {
                return false;
            }
        }
        return true;
    }
}