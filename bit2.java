package Samsung_DX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class bit2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int testCase = 1; testCase<=t; testCase++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            StringBuilder binary = new StringBuilder();
            for(int i=0; i<n; i++){
                binary.append("1");
            }
            int k = Integer.parseInt(binary.toString(), 2);
            String res = "ON";
            if((k&m) != k) res = "OFF";



            sb.append('#').append(testCase).append(' ').append(res).append('\n');



        }
        System.out.println(sb);








    }
}