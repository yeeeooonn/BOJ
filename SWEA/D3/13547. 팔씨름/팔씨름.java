import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= T; t++) {
            //x가 8번 이상이면 no, 아니면 yes
            String str= br.readLine();
            int count = 0;
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if(c == 'x') count++;
            }

            sb.append("#").append(t).append(" ");
            if(count >= 8) {
                sb.append("NO");
            }else {
                sb.append("YES");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}