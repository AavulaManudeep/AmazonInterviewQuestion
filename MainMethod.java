import java.util.LinkedList;
import java.util.Queue;

public class MainMethod {

    public static void main(String[] args)
    {
        System.out.println("Hello New OS");
        System.out.println(bfs());
    }
    public static int bfs()
    {

        int[][] bfsarray = {{1,10,0},{1,0,0},{1,1,0}};
        boolean[][] visitflag = new boolean[3][3];
        int[][] distance = new int[3][3];
        int[] next_row = {-1,1,0,0};
        int[] next_column = {0,0,-1,1};
        Queue<String> queue = new LinkedList<>();
        queue.add(0+","+0);
        distance[0][0] = 0;
        while (!queue.isEmpty())
        {
            String current_block = queue.poll();
            int row = Integer.parseInt(current_block.split(",")[0]);
            int column = Integer.parseInt(current_block.split(",")[1]);
            visitflag[row][column] = true;
            if(bfsarray[row][column]>1)
            {
                return distance[row][column];
            }
            for(int i=0;i<4;i++)
            {
                if(rangecheck(next_row[i]+row,next_column[i]+column)
                        && bfsarray[next_row[i]+row][next_column[i]+column]!=0
                        && visitcheck(visitflag,next_row[i]+row, next_column[i]+column))
                {
                   queue.add((next_row[i]+row)+","+(next_column[i]+column));
                   distance[next_row[i]+row][next_column[i]+column] = distance[row][column]+1;
                }
            }

        }
        return -1;
    }

    public static boolean visitcheck(boolean[][] visitflag,int row,int column)
    {
        return !visitflag[row][column];
    }

    public static boolean rangecheck(int row,int column)
    {
        return row>=0 && row<3 && column>=0 && column<3;
    }
}
