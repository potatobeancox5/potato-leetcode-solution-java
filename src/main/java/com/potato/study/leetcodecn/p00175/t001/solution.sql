# Write your MySQL query statement below
SELECT FirstName, LastName, City, State FROM  Person as a LEFT JOIN Address as b ON a.PersonId = b.PersonId;