package com.example.finance_tracker.repository;

import com.example.finance_tracker.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TransactionRepository
extends JpaRepository<Transaction, Long> {

    @Query("""

SELECT

t.description,

SUM(
t.amount
)

FROM Transaction t

GROUP BY

t.description

ORDER BY

SUM(
t.amount
)

DESC

LIMIT 5

""")

List<Object[]>

topExpenses();


@Query("""

SELECT

FUNCTION(
'TO_CHAR',
t.transactionDate,
'YYYY-MM'
),

SUM(
t.amount
)

FROM Transaction t

GROUP BY

FUNCTION(
'TO_CHAR',
t.transactionDate,
'YYYY-MM'
)

ORDER BY

FUNCTION(
'TO_CHAR',
t.transactionDate,
'YYYY-MM'
)

""")

List<Object[]>

getTrend();

    @Query("""

SELECT

CAST(
t.category
AS string
),

SUM(
t.amount
)

FROM Transaction t

GROUP BY

t.category

ORDER BY

SUM(
t.amount
)

DESC

""")

List<Object[]>
getCategorySpend();

    @Query("""
SELECT
SUM(t.amount)
FROM Transaction t
WHERE EXTRACT(
MONTH FROM t.transactionDate
)=:month
""")

Double getMonthlySpend(
Integer month
);


 @Query("""

SELECT

FUNCTION(
'TO_CHAR',
t.transactionDate,
'YYYY-MM'
),

SUM(
t.amount
)

FROM Transaction t

GROUP BY

FUNCTION(
'TO_CHAR',
t.transactionDate,
'YYYY-MM'
)

ORDER BY

FUNCTION(
'TO_CHAR',
t.transactionDate,
'YYYY-MM'
)

""")
List<Object[]>
getMonthlySpend();

@Query("""

SELECT
COALESCE(
SUM(amount),
0
)

FROM Transaction

WHERE

EXTRACT(
MONTH
FROM
transactionDate
)

=

EXTRACT(
MONTH
FROM
CURRENT_DATE
)

""")

java.math.BigDecimal
getCurrentMonthSpend();

}