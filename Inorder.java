import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Inorder {
    static int n;
    static char[] tree;
    static StringBuilder sb;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        for(int testCase=1; testCase<=10; testCase++) {
            n = Integer.parseInt(br.readLine());
            tree = new char[n + 1];
            for (int i = 1; i <= n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                st.nextToken();
                char c = st.nextToken().charAt(0);
                tree[i] = c;
            }
            sb.append('#').append(testCase).append(' ');
            inOrder(1);
            sb.append('\n');



        }
        System.out.println(sb);
    }
    public static void inOrder(int index){
        if(index>n) return;

        inOrder(2*index);
        sb.append(tree[index]);
        inOrder(2*index+1);
    }
}
