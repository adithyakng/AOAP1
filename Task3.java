
import java.io.*;
import java.util.*;

public class Task3{

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
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ArrayList<Integer> houseIndexes = new ArrayList<Integer>();
        PriorityQueue<House> pq = new PriorityQueue<House>(5, new HouseComparator());
        int currentDay = 1;
        int currentHouseIndex = 0;
        // for(int i=0; i<n; i++){
        //     pq.add(new House(input[i][0], input[i][1], i));
        // }
        // for(int i=0; i<n; i++){
        //     System.out.println(pq.poll());
        // }
        for(int i=0; i<m;i++){
            if(input[i][0] == 0){
                pq.add(new House(input[i][0], input[i][1], i));
            }
            else{
                break;
            }
        }
        while(currentDay <= n){
            while(currentHouseIndex < m && input[currentHouseIndex][0] <= currentDay){
                pq.add(new House(input[currentHouseIndex][0],input[currentHouseIndex][1], currentHouseIndex));
                currentHouseIndex++;
            }
            while(pq.size() > 0 && pq.peek().endDay < currentDay){
                pq.poll();
            }
            if(pq.size() > 0){
                houseIndexes.add(pq.poll().index);
            }
            currentDay++;
        }

        for(int i=0; i<houseIndexes.size(); i++){
            bw.write(houseIndexes.get(i)+ " ");
        }
        bw.flush();
    }
}

class House{
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

class HouseComparator implements Comparator<House>{

    public int compare(House h1, House h2){
        int h1Diff = h1.endDay - h1.startDay;
        int h2Diff = h2.endDay - h2.startDay;
        if(h1Diff > h2Diff){
            return 1;
        }
        else if(h1Diff == h2Diff){
            if(h1.endDay > h2.endDay){
                return 1;
            }
            else if(h1.endDay < h2.endDay){
                return -1;
            }
            else{
                return h1.index < h2.index ? -1 : 1;
            }
        }
        else{
            return -1;
        }
    }

}