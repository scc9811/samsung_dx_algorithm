package Samsung_DX;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class LinkedList2 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for(int testCase=1; testCase<=t; testCase++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            LinkedList<Integer> list = new LinkedList<>();
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<n; i++){
                list.add(Integer.parseInt(st.nextToken()));
            }
            for(int i=0; i<m; i++){
                st = new StringTokenizer(br.readLine());
                char c = st.nextToken().charAt(0);
                if(c=='I'){
                    list.add(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
                }
                else if(c=='D'){
                    list.remove(Integer.parseInt(st.nextToken()));
                }
                else if(c=='C'){
                    int id = Integer.parseInt(st.nextToken());
                    list.remove(id);
                    list.add(id, Integer.parseInt(st.nextToken()));
                }
            }
            int res;
            if(list.size()<=l){
                res = -1;
            }
            else res = list.get(l);
            sb.append('#').append(testCase).append(' ').append(res).append('\n');
        }
        System.out.println(sb);









    }
}
