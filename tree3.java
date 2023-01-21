package Samsung_DX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class tree3 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int testCase=1; testCase<=t; testCase++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int[] par = new int[v+1];
            int[] char1 = new int[v+1];
            int[] char2 = new int[v+1];

            int ver1 = Integer.parseInt(st.nextToken());
            int ver2 = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<e; i++){
                int p = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                par[c] = p;
                if(char1[p]==0) char1[p] = c;
                else char2[p] = c;
            }

            Set<Integer> set = new HashSet<>();
            for(int i=par[ver1]; i!=0; i=par[i]){
                set.add(i);
            }
            int id = -1;
            for(int i=par[ver2]; i!=0; i=par[i]){
                if(set.contains(i)){
                    id = i;
                    break;
                }
            }


            Queue<Integer> queue = new LinkedList<>();
            queue.add(id);
            int count = 0;
            while(!queue.isEmpty()){
                count++;
                int node = queue.poll();
                if(char1[node]==0) continue;
                queue.add(char1[node]);
                if(char2[node]==0) continue;
                queue.add(char2[node]);
            }
            sb.append('#').append(testCase).append(' ').append(id).append(' ').append(count).append('\n');
        }
        System.out.println(sb);



    }
}
