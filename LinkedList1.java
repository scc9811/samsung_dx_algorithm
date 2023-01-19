package Samsung_DX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class LinkedList1 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for(int testCase = 1; testCase<=10; testCase++){
            int n = Integer.parseInt(br.readLine());
            LinkedList<Integer> list = new LinkedList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<n; i++){
                list.add(Integer.parseInt(st.nextToken()));
            }
            int count = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<count; i++){
                char c = st.nextToken().charAt(0);
                if(c=='I'){
                    int x = Integer.parseInt(st.nextToken());
                    int y = Integer.parseInt(st.nextToken());
                    for(int j=0; j<y; j++){
                        list.add(x+j, Integer.parseInt(st.nextToken()));
                    }
                }
                else if(c=='D'){
                    int x = Integer.parseInt(st.nextToken());
                    int y = Integer.parseInt(st.nextToken());
                    for(int j=0; j<y; j++){
                        list.remove(x);
                    }

                }
                else if(c=='A'){
                    int y = Integer.parseInt(st.nextToken());
                    for(int j=0; j<y; j++){
                        list.add(Integer.parseInt(st.nextToken()));
                    }


                }
            }

            sb.append('#').append(testCase).append(' ');
            for(int i=0; i<10; i++){
                sb.append(list.get(i)).append(' ');
            }
            sb.append('\n');

        }
        System.out.println(sb);










    }
}
