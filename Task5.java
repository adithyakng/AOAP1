import java.io.*;
import java.util.*;

public class Task5 {

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
        performTask5(n,m,days);
    }

    public static void performTask5(int n, int m, int[][] input){
        PriorityQueue<House> pq = new PriorityQueue<House>(5, new HouseComparatorTask5());
        int currentDay = 1;
        int currentHouseIndex = 0;

        while(currentHouseIndex <m){

            // If startDate is greater than n, then ignore all future houses
            if(input[currentHouseIndex][0] > n){
                break;
            }
            
            // Process all the houses present in the priority queue till currentDay equal to current house startDay
            while(currentDay < input[currentHouseIndex][0]){
                // If the priority queue size is zero, then the currentDay will be equal to the startDate of the current house.
                if(pq.size() == 0){
                    currentDay = input[currentHouseIndex][0];
                }
                 // select the house on the top of the prioirty queue to paint
                else{
                    House topHouse = pq.poll();
                    if(topHouse.endDay >= currentDay){
                        System.out.print(topHouse.index+" ");
                        currentDay++;
                    }
                }
            }
            // Push the house available to be painted on currentDay into the priority queue.
            if(input[currentHouseIndex][0] <= currentDay){
                pq.add(new House(input[currentHouseIndex][0], input[currentHouseIndex][1], currentHouseIndex+1));
            }
            currentHouseIndex++;
        }

        // If any houses are remaining in the priority queue, poll them and paint if possible
        while(currentDay <=n && pq.size() > 0){
            House topHouse = pq.poll();
            if(topHouse.endDay >= currentDay){
                System.out.print(topHouse.index+" ");
                currentDay++;
            }
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

class HouseComparatorTask5 implements Comparator<House>{

    public int compare(House h1, House h2){
        if(h1.endDay > h2.endDay){
             // Give more priority to h2
            return 1;
        }
        else if(h1.endDay == h2.endDay){
            if(h1.startDay < h2.startDay){
                  // Give more priority to h1
                return -1;
            }
            else if(h1.startDay > h2.startDay){
                // Give more priority to h2
                return 1;
            }
            else{
                // Else give priority to higher index
                return h1.index < h2.index ? 1 : -1;
            }
        }
        else{
            // Give more priority to h1
            return -1;
        }
    }

}