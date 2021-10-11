father(anton, bart).
father(anton, daan).
father(anton, elisa).
father(fabian, anton).


mother(celine, bart).
mother(celine, daan).
mother(celine, gerda).
mother(gerda, hendrik).

sibling(X, Y) :-
    father(F, X),
    father(F, Y),
    mother(M, X),
    mother(M, Y),
    X \== Y.

peano_plus(zero, X, X).
peano_plus(s(X), Y, s(Z)) :- peano_plus(X,Y,Z).

peano_min(X, zero, X).
peano_min(s(X), s(Y), Z) :- peano_min(X,Y,Z).
