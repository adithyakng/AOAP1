Stratergy 2 Counter Example:

Consider the following date ranges
A (1,2)
B (2,3)
C (3,4)
D (3,5)
E (3,6)
F (3,10)
G (4,5)

Current Stratergy: Iterate over each day starting from day 1 . . . n. For each day, among the unpainted houses
that are available that day, paint the house that started being available the latest.

If we follow the above algorithm, then on day 1 we paint house A, on day 2 we paint house B, on day 3 we have a total of 4 available houses { C,D,E,F}, among these houses house F is latest ( Consider the house with highest endDay be latest if startDay are equal), so we choose house F to paint on day 3. On day 4 we have C,D,E,G houses available to paint, latest is G so we paint G on day 4. On day 5 we have D and E, latest is E so we paint E on day 5. Houses C & D remain unpainted.
So houses { A->B->F->G->E} will be painted.

However an optimal solution can be painting house A to D each on a day, so we out of 4 days. On the fifth day we can paint G, followed by E on sixth day and F on the seventh day.
So we can paint all the seven houses in the order {A->B->C->D->G->E->F} order.


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

