package Samsung_DX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class bit3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int testCase = 1; testCase<=t; testCase++){
            String s = br.readLine();
            int[][] dp = new int[s.length()][16];

            int len = s.length();
            for(int i=0; i<16; i++){
                int tmp = 1<<(s.charAt(0)-'A');
                if((i&tmp) > 0 && (i&1)>0){
                    dp[0][i] = 1;
                }
            }
            for(int i = 1; i<len; i++){
                int tmp = 1<<(s.charAt(i)-'A');
                for(int j=0; j<16; j++){
                    if(dp[i-1][j]!=0) {
                        for(int k=0; k<16; k++){
                            if((j&k) > 0 && (tmp&k)>0){
                                dp[i][k] = (dp[i][k] + dp[i-1][j])%1000000007;
                            }
                        }
                    }
                }
            }

            long count = 0;
            for(int i=0; i<16; i++){
                count = (count+dp[len-1][i])%1000000007;
            }
            sb.append('#').append(testCase).append(' ').append(count).append('\n');


        }
        System.out.println(sb);








    }
}