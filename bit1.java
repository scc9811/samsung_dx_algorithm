package Samsung_DX;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bit1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int testCase=1; testCase<=t; testCase++){
            boolean[] check = new boolean[10];
            long n = Long.parseLong(br.readLine());
            int mul = 1;
            while(true){
                String s = String.valueOf(n*mul++);
                for(int i=0; i<s.length(); i++){
                    check[s.charAt(i)-'0'] = true;
                }
                boolean checkTf = true;
                for(int i=0; i<10; i++){
                    if(!check[i]){
                        checkTf = false;
                        break;
                    }
                }
                if(checkTf) break;
            }
            sb.append('#').append(testCase).append(' ').append(n*(mul-1)).append('\n');
        }
        System.out.println(sb);









    }
}