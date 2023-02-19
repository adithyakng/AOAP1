
import java.io.*;
import java.util.*;

public class Task1{

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input[] = br.readLine().trim().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int days[][] = new int[m][2];
        for(int i=0; i<m;i++){
            input = br.readLine().trim().split(" ");
            days[i][0] = Integer.parseInt(input[0]);
            days[i][1] = Integer.parseInt(input[1]);
        }
        performTask(n,m,days);
    }

    public static void performTask(int n, int m, int[][] input) throws IOException{
        int currentHouseIndex = 0;
        for(int i=1; i<=n; i++){
            if(i<=m && input[currentHouseIndex][0] <= i && input[currentHouseIndex][1] >= i){
                System.out.print((currentHouseIndex+1)+" ");
                currentHouseIndex++;
            }
        }
    }
}