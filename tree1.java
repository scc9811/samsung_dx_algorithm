package Samsung_DX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class tree1 {
    static char[] tree;
    static int n;
    static StringBuilder res;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for(int testCase=1; testCase<=10; testCase++){
            n = Integer.parseInt(br.readLine());
            tree = new char[n+1];
            for(int i=1; i<=n; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                st.nextToken();
                tree[i] = st.nextToken().charAt(0);
            }
            res = new StringBuilder();


            InOrder(1);
            boolean tf = true;
            boolean lastNum;
            if(res.charAt(0)>='0' && res.charAt(0)<='9'){
                lastNum = true;
            }
            else lastNum = false;
            for(int i=1; i<n; i++){
                char c = res.charAt(i);
                if(lastNum){
                    if(c>='0' && c<='9'){
                        tf =false;
                        break;
                    }
                    lastNum = false;
                }
                else{
                    if(c<'0' || c>'9'){
                        tf = false;
                        break;
                    }
                    lastNum = true;
                }
            }
            sb.append('#').append(testCase).append(' ');
            if(tf) sb.append(1);
            else sb.append(0);
            sb.append('\n');
        }
        System.out.println(sb);



    }
    public static void InOrder(int id){
        if(id>n) return;
        InOrder(2*id);
        res.append(tree[id]);
        InOrder(2*id+1);
    }
}
