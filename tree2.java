package Samsung_DX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class tree2 {
    static int n;
    static Node[] arr;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for(int testCase=1; testCase<=10; testCase++){
            n = Integer.parseInt(br.readLine());
            arr = new Node[n+1];

            for(int i=1; i<=n; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                st.nextToken();
                arr[i] = new Node(st.nextToken());
                if(st.hasMoreElements()){
                    arr[i].left = Integer.parseInt(st.nextToken());
                    arr[i].right = Integer.parseInt(st.nextToken());
                }
            }
            sb.append('#').append(testCase).append(' ').append((int)calculate(1)).append('\n');
        }

        System.out.println(sb);


    }
    public static double calculate(int id){
        if(arr[id].left==-1) return Double.parseDouble(arr[id].s);

        char cal = arr[id].s.charAt(0);
        switch(cal){
            case '+' : return calculate(arr[id].left) + calculate(arr[id].right);
            case '-' : return calculate(arr[id].left) - calculate(arr[id].right);
            case '*' : return calculate(arr[id].left) * calculate(arr[id].right);
            case '/' : return calculate(arr[id].left) / calculate(arr[id].right);
        }


        return 0.0;
    }
    public static class Node{
        String s;
        int left = -1;
        int right = -1;
        Node(String s){
            this.s = s;
        }
    }
}
