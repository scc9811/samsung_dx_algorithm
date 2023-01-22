package Samsung_DX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class bfs1 {
    static int n, arr[][];
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int testCase=1; testCase<=t; testCase++){
            n = Integer.parseInt(br.readLine());
            arr = new int[n][n];
            Queue<Point> queue = new LinkedList<>();
            for(int i=0; i<n; i++){
                String s = br.readLine();
                for(int j=0; j<n; j++){
                    arr[i][j] = s.charAt(j);
                    if(arr[i][j]=='.') queue.add(new Point(i, j));
                }
            }
            int count = 0;
            while(!queue.isEmpty()){
                Point p = queue.poll();
                if(arr[p.x][p.y]=='*') continue;
                count++;
                BFS(p);
            }
            System.out.println(count);

        }




    }
    static int dx[] = {0,0,-1,1};
    static int dy[] = {-1,1,0,0};
    public static void BFS(Point p){
        Queue<Point> queue = new LinkedList<>();
        queue.add(p);
        arr[p.x][p.y] = '*';
        while(!queue.isEmpty()){
            Point point = queue.poll();
            for(int i=0; i<4; i++){
                int newI = point.x+dx[i];
                int newJ = point.y+dy[i];
                if(newI>=0 && newI<n && newJ>=0 && newJ<n && arr[newI][newJ]=='.'){
                    arr[newI][newJ] = '*';
                    queue.add(new  Point(newI, newJ));
                }
            }
        }
    }
    public static class Point{
        int x, y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
