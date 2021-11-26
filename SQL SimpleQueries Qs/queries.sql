SELECT * FROM designation; -- List all the designation
SELECT * FROM employees; -- List all the employees
SELECT * FROM payments; -- List all the payments
SELECT * FROM interview; -- List all the interview
SELECT * FROM vacancies; -- List all the vacancies
SELECT * FROM projects; -- List all the projects
SELECT * FROM projectstatus; -- List all the projectstatus
SELECT * FROM applicanstatus; -- List all the applicanstatus
SELECT * FROM attendance; -- List all the attendance
SELECT * FROM view_; -- List all the view
    
SELECT * FROM projects, projectstatus; -- List projects with 2 tables, which has projectid = 1
	WHERE projectid = 1;

SELECT * FROM vacancies, applicanstatus, interview; -- List three tables together

SELECT stid, interviewed -- If their cases are equal, combine the ids of the two separate tables and return their values in the two tables. 
  FROM interview i
  FULL OUTER JOIN applicanstatus a
  ON a.aboutstatus = i.status;

SELECT -- Lists average allowances from payments table whose date is 2020-12-17 or 2020-12-18
	AVG (allowances)
FROM
	payments
WHERE
	date_ = '2020-12-17'
    OR
    date_ = '2020-12-18';
    
SELECT -- Count how many lines payment has and return
   COUNT(*)
FROM
   payment;
   
SELECT -- Sort in descending order by taking the date and total values from the payment table, 
	date_,
	SUM (basicpay) AS total -- the name of the basicapay value being total.
FROM
	payment
GROUP BY
	date_
ORDER BY total DESC
LIMIT 5; --  with a maximum of 5

SELECT -- Sort date values with basicpay value greater and less than 300 and return these two columns
	date_,
	SUM (basicpay)
FROM
	payment
GROUP BY
	date_
HAVING
	SUM (basicpay) > 300;