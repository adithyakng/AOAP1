Stratergy 2 Counter Example:

Consider the following date ranges with n=8 and m=8
A (1,2)
B (2,3)
C (3,4)
D (3,5)
E (3,7)
F (4,5)
G (5,6)
H (6,8)

Current Strategy: Iterate over each day starting from day 1 . . . n. For each day, among the unpainted houses
that are available that day, paint the house that started being available the latest.

If we follow the above algorithm, then on day 1 we paint house A, on day 2 we paint house B, on day 3 we paint house C and on day 4 we paint house F , followed by G and H on day 5 and 6 respectively. Next on day 7 we paint house E and house D remains unpainted. So 7 houses will be painted in the following order 1 each day. {A->B->C->F->G->H->E} 

However an optimal solution can be painting house A on day 1, house B on day 2, house C on day 3 , house D on day 4, house F on day 5, house G on day 6, house E on day 7 and finally house H on day 8.
So all 8 houses will be painted in the following order 1 each day. {A->B->C->D->F->G->E->H} 


Algorithm:

    n,m <- Max days, Number of houses
    input[][] <- n 2-dimensional arrays storing startDay and endDay of each home
    ans <- []
    currentDay <- 1
    currentHouseIndex <- 0;
    pq <- EMPTY PRIORITY QUEUE

    WHILE currentDay <= n:
        WHILE currentHouseIndex < m AND input[currentHouseIndex][0] <= currentDay
            pq.add(HOUSE(currentHouseIndex))
            currentHouseIndex++;
        WHILE(pq.size() > 0 AND pq.peek().endDay < currentDay)
            pq.poll()
        IF(pq.size() > 0)
            ans <- pq.poll()
        
        curentDay++;

