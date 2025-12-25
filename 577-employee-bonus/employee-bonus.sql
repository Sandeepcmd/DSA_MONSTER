# Write your MySQL query statement below
SELECT name,bonus FROM Employee AS e LEFT JOIN Bonus as b ON e.empId = b.empId
WHERE b.bonus < 1000 OR b.bonus is NULL;
