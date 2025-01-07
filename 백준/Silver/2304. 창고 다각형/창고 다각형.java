import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] height;
    static class Node {
        int x;
        int y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        height = new int[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            height[i][0] = Integer.parseInt(st.nextToken());
            height[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(height,(a,b) ->  {
            if(a[0] == b[0]) return a[1] - b[1];
            else return a[0] - b[0];
        });

        int highPoint = 0;
        int highValue = 0;
        for (int i = 0; i < N; i++) {
            if(highValue < height[i][1]) {
                highValue = height[i][1];
                highPoint = i;
            }
        }

        Stack<Node> stack = new Stack<>();
        stack.push(new Node(height[0][0], height[0][1]));

        int result = 0;
        //왼쪽부터 가장큰높이 전까지의 넓이
        for (int i = 1; i <= highPoint; i++) {
            //stack의 값보다 큰 높이라면 이전까지의 넓이 계산
            //작은 높이라면 아무것도 안해도된다.
            if(stack.peek().y < height[i][1]) {
                Node cur = stack.pop();
                result += cur.y * (height[i][0] - cur.x);
                stack.push(new Node(height[i][0], height[i][1]));
            }
        }

        //왼쪽부터 가장큰높이 전까지의 넓이
        stack = new Stack<>();
        stack.push(new Node(height[N-1][0], height[N-1][1]));
        for (int i = N-2; i >= highPoint; i--) {
            //stack의 값보다 큰 높이라면 이전까지의 넓이 계산
            //작은 높이라면 아무것도 안해도된다.
            if(stack.peek().y < height[i][1]) {
                Node cur = stack.pop();
                result += cur.y * (cur.x - height[i][0]);
                stack.push(new Node(height[i][0], height[i][1]));
            }
        }

        //가장 큰 높이 계산 -> stack에 들어있는 위치값으로 가장 큰 높이의 넓이를 알 수 있음
        Node high = stack.pop();
        result += high.y * (high.x - height[highPoint][0] +1);
        
        System.out.println(result);

    }
}