package Samsung_DX;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class mine_Search{
    static int[] dx = {1,1,0,-1,-1,-1,0,1};
    static int[] dy = {0,-1,-1,-1,0,1,1,1};
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for(int testCase=1; testCase<=t; testCase++){
            int n = Integer.parseInt(br.readLine());
            char[][] arr = new char[n][n];
            for(int i=0; i<n; i++){
                arr[i] = br.readLine().toCharArray();
            }

            PriorityQueue<Point> priorityQueue = new PriorityQueue<>();
            for(int i=0; i<n; i++) {
                for (int j = 0; j < n; j++) {
                    if (arr[i][j] == '*') continue;
                    int mineCount = 0;
                    for (int k = 0; k < 8; k++) {
                        int newX = i + dx[k];
                        int newY = j + dy[k];
                        if (newX >= 0 && newX < n && newY >= 0 && newY < n && arr[newX][newY] == '*') mineCount++;
                    }
                    priorityQueue.add(new Point(i, j, mineCount));
                }
            }
            int res = 0;
            while(!priorityQueue.isEmpty()){
                Point p = priorityQueue.poll();
                System.out.println("loc = "+p.x+", "+p.y);
                System.out.println("PointMine = "+p.mine);
                if(arr[p.x][p.y]!='.') continue;
                Queue<Point> queue = new LinkedList<>();
                arr[p.x][p.y] = (char) p.mine;








            }





        }
        System.out.println(sb);







    }
    public static class Point implements Comparable<Point>{
        int x, y, mine;
        Point(int x, int y, int mine){
            this.x = x;
            this.y = y;
            this.mine = mine;
        }
        public int compareTo(Point p){
            return Integer.compare(this.mine, p.mine);
        }
    }
}