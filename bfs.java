package Samsung_DX;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bfs{

    private final static UserSolution usersolution = new UserSolution();

    private static BufferedReader br;

    private static int cmd_bfs() throws Exception {

        int score = 100;
        int N, M, x1, y1, x2, y2, dist, ans;
        int[][] map = new int[10][10];
        String str;
        StringTokenizer st;

        br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();
        N = Integer.parseInt(str);

        for(int i = 0; i < N; i++) {
            str = br.readLine();
            st = new StringTokenizer(str, " ");
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        usersolution.bfs_init(N, map);

        str = br.readLine();
        M = Integer.parseInt(str);


        for(int i = 1; i <= M; i++) {
            System.out.println("testCase = "+i);
            str = br.readLine();
            st = new StringTokenizer(str, " ");
            x1 = Integer.parseInt(st.nextToken());
            y1 = Integer.parseInt(st.nextToken());
            x2 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());
            ans = Integer.parseInt(st.nextToken());

            dist = usersolution.bfs(x1, y1, x2, y2);
            System.out.println("dist = "+dist);
            if(dist != ans) {
                score = 0;
            }
        }
        return score;
    }

    public static void main(String[] args) throws Exception {
        System.out.println("#total score : " + cmd_bfs());
    }
    public static class UserSolution {
        private int queueX[], queueY[], mapSize, map[][];
        void bfs_init(int map_size, int map[][]) {
            this.mapSize = map_size;
            this.map = map;
        }

        int bfs(int x1, int y1, int x2, int y2) {
            x1--;
            x2--;
            y1--;
            y2--;
            if(x1==x2 && y1==y2) return 0;

            int tmp1 = x1;
            x1 = y1;
            y1 = tmp1;


            int tmp2 = x2;
            x2 = y2;
            y2 = tmp2;

            boolean[][] visited = new boolean[mapSize][mapSize];
            if(map[x2][y2]==1) return -1;
            visited[x1][y1] = true;
            int left = 0;
            int right = 0;
            int[] dx = {0,0,1,-1};
            int[] dy = {1,-1,0,0};
            queueX = new int[10000];
            queueY = new int[10000];
            queueX[right] = x1;
            queueY[right++] = y1;
            int count = 0;
            int tmp = 1;
            while(left!=right){
                tmp--;
                if(tmp==0){
                    count++;
                    tmp = right-left;
                }
                int x = queueX[left];
                int y = queueY[left++];
                for(int i=0; i<4; i++){
                    int newX = x+dx[i];
                    int newY = y+dy[i];
                    if(newX>=0 && newX<mapSize && newY>=0 && newY<mapSize && map[newX][newY]==0 && !visited[newX][newY]){
                        if(newX==x2 && newY==y2) return count;
                        queueX[right] = newX;
                        queueY[right++] = newY;
                        visited[newX][newY] = true;
                    }
                }
            }





            return -1;
        }
    }

}