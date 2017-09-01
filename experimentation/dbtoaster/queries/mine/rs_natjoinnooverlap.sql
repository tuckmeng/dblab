CREATE STREAM R(A int, B int)
FROM FILE '../../experiments/data/simple/tiny/r.dat' LINE DELIMITED
CSV ();

CREATE STREAM S(C int, D int)
FROM FILE '../../experiments/data/simple/tiny/r.dat' LINE DELIMITED
CSV ();

SELECT R.A AS A, R.B AS B FROM R AS R NATURAL JOIN S AS S;