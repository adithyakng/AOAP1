Stratergy 1 Counter Example:

Consider the following date ranges
A (1,2)
B (2,3)
C (3,4)
D (3,5)
E (3,6)
F (3,10)
G (4,5)

If we follow the algorithm of choosing to paint the house that started being available the earliest, then in that case
we start with painting house A on day 1, house B on day 2, house C on day 3, house D on day 4, house E on day 5 and house F on day 6. As house G is not available on day 7 we cannot paint it. So a total of 6 {A,B,C,D,E,F} houses are painted. However an optimal solution can be painting house A to D each on a day, so we out of 4 days. On the fifth day instead of painting E we can paint G, followed by E on sixth day and F on the seventh day.
So we can paint all the seven houses in the order {A->B->C->D->G->E->F} order.

Algorithm:
    n,m <- Max days, Number of houses
    input[][] <- n 2-dimensional arrays storing startDay and endDay of each home
    ans <- []

    FOR i=0 to n-1
        IF input[i][0] <= day and day <= input[i][1]
            Add(ans,i);

    PRINT_LIST(ans);
return count;
