Stratergy 3 counter example:

Consider the following example:

A (1,2)
B (1,4)
C (2,4)
D (3,4)
E (3,5)

Current Stratergy: Iterate over each day starting from day 1 . . . n. For each day, among the unpainted houses
that are available that day, paint the house that is available for the shortest duration.

If we follow the above algorithm, for day 1 we have both A & B available. As A is available for the shortest duration (1 day) than B (3 days), we choose to paint A. On day 2, we have B and C available to paint and C is available for 2 days while B is available for 3 days, hence we choose C (shortest available). Next on day 3 we have B, D, E houses available and each of them are available for 3,1,2 days respectively. We choose to paint D on day 3. On day 4 we have B and E houses available to paint.
We choose E to paint as it is available for 2 days while B is available for 3 days. We cannot paint the remaining house B on fifth day because it's endDay is 4.
So the houses are painted in the following order {A->C->D->E}.

However an optimal solution exists, paint A on day 1, paint C on day 2, paint D on day 3, paint B on day 4 and finally paint E on day 5.
So all the houses can be painted in the following order {A->C->D->B->E}