import java.io.*;
import java.time.Instant;
import java.time.Duration;
import java.util.*;

public class CompareTasks {
    
    public static void main(String args[]) throws IOException{

        int[] inputSizes = {1000,10000,25000,50000,100000};
        String fileName;
        BufferedReader br;
        String input[];
        int n,m;
        int days[][];
        for(int index = 0; index<inputSizes.length; index++){
            fileName = "input_"+inputSizes[index]+".txt";
            br = new BufferedReader(new FileReader(fileName));
            input = br.readLine().trim().split(" ");
            n = Integer.parseInt(input[0]);
            m = Integer.parseInt(input[1]);
            days = new int[m][2];
            for(int i=0; i<m;i++){
                input = br.readLine().trim().split(" ");
                days[i][0] = Integer.parseInt(input[0]);
                days[i][1] = Integer.parseInt(input[1]);
            }
            System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
            System.out.println("n value: " +n);
            System.out.println("m value: " +m);
            System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
            performTask1(n,m,days);
            performTask2(n,m,days);
            performTask3(n,m,days);
            performTask4(n,m,days);

        }
    }

    public static void performTask1(int n, int m, int[][] input){
        System.out.println("TASK 1");
        System.out.println();
        final Instant startTime = Instant.now();
        int currentDay = 1;
        int currentHouseIndex = 0;
        int count = 0;
        while(currentDay <=n && currentHouseIndex<m){
            if(input[currentHouseIndex][0] <= currentDay && input[currentHouseIndex][1] >= currentDay){
                currentHouseIndex++;
                currentDay++;
                count++;
            }
            else if(input[currentHouseIndex][0] > currentDay){
                currentDay = input[currentHouseIndex][0];
            }
            else{
                currentHouseIndex++;
            }
        }
        final Instant endTime = Instant.now();
        System.out.println("Total Number of houses painted: "+count);
        System.out.println("Total Time taken in nano seconds: "+(Duration.between(startTime,endTime).toNanos()));
        System.out.println("--------------------");
    }

    public static void performTask2(int n, int m, int[][] input){
        System.out.println("TASK 2");
        System.out.println();
        final Instant startTime = Instant.now();
        int count = 0;
        PriorityQueue<House> pq = new PriorityQueue<House>(5, new HouseComparatorTask2());
        int currentDay = 1;
        int currentHouseIndex = 0;
        while(currentDay <= n){
            while(currentHouseIndex < m && input[currentHouseIndex][0] <= currentDay){
                pq.add(new House(input[currentHouseIndex][0],input[currentHouseIndex][1], currentHouseIndex+1));
                currentHouseIndex++;
            }
            // Remove all houses that end before the current day from the priority queue
            while(pq.size() > 0 && pq.peek().endDay < currentDay){
                pq.poll();
            }
            // Add the house with the earliest end day to the list of chosen houses
            if(pq.size() > 0){
                pq.poll();
                count++;
            }
            currentDay++;
        }

        final Instant endTime = Instant.now();
        System.out.println("Total Number of houses painted: "+count);
        System.out.println("Total Time taken in nano seconds: "+(Duration.between(startTime,endTime).toNanos()));
        System.out.println("--------------------");
    }

    public static void performTask3(int n, int m, int[][] input){
        System.out.println("TASK 3");
        System.out.println();
        final Instant startTime = Instant.now();
        int count = 0;
        PriorityQueue<House> pq = new PriorityQueue<House>(5, new HouseComparatorTask3());
        int currentDay = 1;
        int currentHouseIndex = 0;
        while(currentDay <= n){
            while(currentHouseIndex < m && input[currentHouseIndex][0] <= currentDay){
                pq.add(new House(input[currentHouseIndex][0],input[currentHouseIndex][1], currentHouseIndex+1));
                currentHouseIndex++;
            }
            while(pq.size() > 0 && pq.peek().endDay < currentDay){
                pq.poll();
            }
            if(pq.size() > 0){
                pq.poll(); 
                count++;
            }
            currentDay++;
        }

        final Instant endTime = Instant.now();
        System.out.println("Total Number of houses painted: "+count);
        System.out.println("Total Time taken in nano seconds: "+(Duration.between(startTime,endTime).toNanos()));
        System.out.println("--------------------");
    }

    public static void performTask4(int n, int m, int[][] input){
        System.out.println("TASK 4");
        System.out.println();
        final Instant startTime = Instant.now();
        int count = 0;
        PriorityQueue<House> pq = new PriorityQueue<House>(5, new HouseComparatorTask4());
        int currentDay = 1;
        int currentHouseIndex = 0;
        while(currentDay <= n){
            while(currentHouseIndex < m && input[currentHouseIndex][0] <= currentDay){
                pq.add(new House(input[currentHouseIndex][0],input[currentHouseIndex][1], currentHouseIndex+1));
                currentHouseIndex++;
            }
            while(pq.size() > 0 && pq.peek().endDay < currentDay){
                pq.poll();
            }
            if(pq.size() > 0){
                pq.poll();
                count++;
            }
            currentDay++;
        }
        final Instant endTime = Instant.now();
        System.out.println("Total Number of houses painted: "+count);
        System.out.println("Total Time taken in nano seconds: "+(Duration.between(startTime,endTime).toNanos()));
        System.out.println("--------------------");
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

class HouseComparatorTask2 implements Comparator<House>{

    public int compare(House h1, House h2){
        if(h1.startDay < h2.startDay){
            return 1;
        }
        else if(h1.startDay == h2.startDay){
            if(h1.endDay > h2.endDay){
                return 1;
            }
            else if(h1.endDay < h2.endDay){
                return -1;
            }
            else{
                return h1.index < h2.index ? 1 : -1;
            }
        }
        else{
            return -1;
        }
    }

}


class HouseComparatorTask3 implements Comparator<House>{

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

class HouseComparatorTask4 implements Comparator<House>{

    public int compare(House h1, House h2){
        if(h1.endDay > h2.endDay){
            return 1;
        }
        else if(h1.endDay == h2.endDay){
            if(h1.startDay < h2.startDay){
                return -1;
            }
            else if(h1.startDay > h2.endDay){
                return 1;
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
