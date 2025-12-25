# Write your MySQL query statement below
SELECT c.name as Customers from customers as c LEFT JOIN Orders as o ON c.id = o.customerId where o.customerId is NULL; 