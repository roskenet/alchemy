# Relational Theory

The name RDBMS Relational Data Base Management System is not because there are relations between tables.

The name comes from relational theory that has to do with relational algebra.

## Relational Operations

filter, project, product

grouping, union, intersection, set difference

Commutativity – JOIN(R,S) = JOIN (S,R)
Commutativity means that the order of two relations is not important. If we have two relations, R and S, then R JOIN S will produce the same result as S JOIN R.

Associativity – JOIN(R, JOIN(S,T) = JOIN(JOIN(R,S), T)
Associativity means that if we have three relations, R, S, and T, we can choose to first perform R JOIN S and then JOIN T to the result, or we can first perform S JOIN T and then JOIN R to the result of the first JOIN, and the results will be equivalent in both cases.

Distributivity – JOIN(R, UNION(S,T)) = UNION(JOIN(R,S), JOIN(R, T))
Distributivity means that if we are joining a relation with a UNION of two other relations, the result will be the same as when we perform two joins, R JOIN S and R JOIN T separately, and then UNION the results.
