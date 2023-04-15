import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
		int [] bag = new int[n+1];
		for(int i=1;i<=n;i++) {
            bag[i]=i;
        }	
		for(int i=0;i<m;i++) {
            st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
			int temp=bag[a];
			bag[a]=bag[b];
			bag[b]=temp;
		}
		for(int i=1;i<=n;i++) {
            sb.append(bag[i]+ " ");
        }
		System.out.println(sb.toString());
	}
}