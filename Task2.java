
import java.io.*;
import java.util.*;

public class Task2{

    public static void main(String args[]) throws IOException{

        // Read input from console
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input[] = br.readLine().trim().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int days[][] = new int[m][2];
        for(int i=0; i<m;i++){
            // Read and push m lines of startDay and endDay seperated by space into days array
            input = br.readLine().trim().split(" ");
            days[i][0] = Integer.parseInt(input[0]);
            days[i][1] = Integer.parseInt(input[1]);
        }
        performTask(n,m,days);
    }

    public static void performTask(int n, int m, int[][] input){
        PriorityQueue<House> pq = new PriorityQueue<House>(5, new HouseComparatorTask2());
        int currentDay = 1;
        int currentHouseIndex = 0;
        while(currentDay <= n){

            // Push all houses available to be painted on currentDay into the priority queue.
            while(currentHouseIndex < m && input[currentHouseIndex][0] <= currentDay){
                pq.add(new House(input[currentHouseIndex][0],input[currentHouseIndex][1], currentHouseIndex+1));
                currentHouseIndex++;
            }
            // Remove all houses that end before the current day from the priority queue as they can't be painted
            while(pq.size() > 0 && pq.peek().endDay < currentDay){
                pq.poll();
            }
            // select the house on the top of the prioirty queue to paint
            if(pq.size() > 0){
                System.out.print(pq.poll().index+" ");
            }
            currentDay++;
        }
    }
}

class House{
    // Define a house Class to store these houses in the priority queue.
    int startDay;
    int endDay;
    int index;

    House(int startDay, int endDay, int index){
        this.startDay = startDay;
        this.endDay = endDay;
        this.index = index;
    }

    public String toString(){
        return startDay+" "+endDay+" "+index+"\n";
        
    }
}

class HouseComparatorTask2 implements Comparator<House>{

    public int compare(House h1, House h2){
        
        if(h1.startDay < h2.startDay){
            // Give more priority to h2
            return 1;
        }
        else if(h1.startDay == h2.startDay){
            if(h1.endDay > h2.endDay){
                // Give more priority to h2
                return 1;
            }
            else if(h1.endDay < h2.endDay){
                // Give more priority to h1
                return -1;
            }
            else{
                // Else give priority to higher index (doesn't matter much)
                return h1.index < h2.index ? 1 : -1;
            }
        }
        else{
            // Give more priority to h1
            return -1;
        }
    }

}