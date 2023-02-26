
import java.io.*;
public class Task1{

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input[] = br.readLine().trim().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int days[][] = new int[m][2];
        for(int i=0; i<m;i++){
            // Read and push m lines of startDay and endDay seperated by space
            input = br.readLine().trim().split(" ");
            days[i][0] = Integer.parseInt(input[0]);
            days[i][1] = Integer.parseInt(input[1]);
        }
        performTask(n,m,days);
    }

    public static void performTask(int n, int m, int[][] input){
        int currentDay = 1;
        int currentHouseIndex = 0;
        while(currentDay <=n && currentHouseIndex<m){
            // Check whether currentHouseIndex can be painted on currentDay
            if(input[currentHouseIndex][0] <= currentDay && input[currentHouseIndex][1] >= currentDay){
                currentHouseIndex++;
                currentDay++;
                System.out.print(currentHouseIndex+" ");
            }
            // If startDay of currentHouseIndex is in the future, then initialize it to currentDay
            else if(input[currentHouseIndex][0] > currentDay){
                currentDay = input[currentHouseIndex][0];
            }
            // In any other case we can't paint the house, so increment currentHouseIndex
            else{
                currentHouseIndex++;
            }
        }
    }
}